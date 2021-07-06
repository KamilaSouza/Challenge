package orange.ApiMarvel.Controller;

import orange.ApiMarvel.Controller.Form.UCForm;
import orange.ApiMarvel.Model.Comics;
import orange.ApiMarvel.Model.UsersComics;
import orange.ApiMarvel.Repository.ComicsRepository;
import orange.ApiMarvel.Repository.UCRepository;
import orange.ApiMarvel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userComics")

public class UCController {

    @Autowired
    private ComicsRepository comicsRepository;

    @Autowired
    private UCRepository ucRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<UsersComics> addUserComic(@RequestBody @Valid UCForm UCForm, UriComponentsBuilder uriBuilder) {

        List<Comics> comics = new ArrayList<>();
        for(int i = 0; i < UCForm.getTitle().size(); i++){
            Comics comic = comicsRepository.findByTitle(UCForm.getTitle().get(i));
            comics.add(comic);
        }

        UsersComics usersComics = new UsersComics();
        UCForm.convertUserComics(userRepository, comicsRepository);
        usersComics.setComics(comics);
        usersComics.setUsers(userRepository.findByEmail(UCForm.getEmail()));
        ucRepository.save(usersComics);

        URI uri = uriBuilder.path("/userComics/{id}").buildAndExpand(usersComics.getUsers().getId()).toUri();
        return ResponseEntity.created(uri).body(usersComics);

    }

    @GetMapping
    public ResponseEntity<List<UsersComics>> listUsers() {
        return ResponseEntity.ok().body(ucRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersComics> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ucRepository.findByUsersId(id));
    }

}







