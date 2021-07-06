package orange.ApiMarvel.Controller;

import orange.ApiMarvel.Controller.Dto.ComicsBaseDto;
import orange.ApiMarvel.Model.Comics;
import orange.ApiMarvel.Repository.ComicsRepository;
import orange.ApiMarvel.Service.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comics")
public class ComicsController {

    @Autowired
    private ComicsRepository comicsRepository;

    @Autowired
    private ComicsService comicsService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Comics> addComics(@RequestBody @Valid Integer id, UriComponentsBuilder uriBuilder) {

        ComicsBaseDto comic = comicsService.findById(id);
        Comics novoComic = getComics(comic);
        comicsRepository.save(novoComic);
        URI uri = uriBuilder.path("/comics/{id}").buildAndExpand(novoComic.getId()).toUri();
        return ResponseEntity.created(uri).body(novoComic);
    }

    @GetMapping
    public ResponseEntity<List<Comics>> listComics() {
        return ResponseEntity.ok().body(comicsRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comics> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(comicsRepository.findById(id).get());
    }

    private Comics getComics(ComicsBaseDto comic) {
        Comics novoComic = new Comics();
        novoComic.setComicId(comic.getData().getResults().get(0).getId());
        novoComic.setTitle(comic.getData().getResults().get(0).getTitle());
        novoComic.setPrice(comic.getData().getResults().get(0).getPrices().get(0).getPrice());

        if ((comic.getData().getResults().get(0).getCreators().getItems().isEmpty())) {
            novoComic.setAuthor("Unknown Author");
        } else {
            novoComic.setAuthor(comic.getData().getResults().get(0).getCreators().getItems().get(0).getName());
        }
        if ((comic.getData().getResults().get(0).getIsbn().isBlank())) {
            novoComic.setIsbn("0-0000-0000-0");
        } else {
            novoComic.setIsbn(comic.getData().getResults().get(0).getIsbn());
        }

        novoComic.setDescription(comic.getData().getResults().get(0).getDescription());
        novoComic.setPriceWithDiscount((comic.getData().getResults().get(0).getPrices().get(0).getPrice()));
        return novoComic;
    }
}

