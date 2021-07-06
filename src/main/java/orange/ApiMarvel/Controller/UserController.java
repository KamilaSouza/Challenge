package orange.ApiMarvel.Controller;

import orange.ApiMarvel.Controller.Form.UserForm;
import orange.ApiMarvel.Model.Users;
import orange.ApiMarvel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Users> addUser(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriBuilder) {
        Users users = new Users();
        users.setName(userForm.getName());
        users.setEmail(userForm.getEmail());
        users.setCpf(userForm.getCpf());
        users.setBirthdate(userForm.getBirthdate());
        userRepository.save(users);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(users.getId()).toUri();
        return ResponseEntity.created(uri).body(users);
    }

    @GetMapping
    public ResponseEntity<List<Users>> listUsers() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Users>> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userRepository.findById(id));
    }

}








