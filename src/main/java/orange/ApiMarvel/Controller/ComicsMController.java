package orange.ApiMarvel.Controller;

import orange.ApiMarvel.Controller.Dto.ComicsBaseDto;
import orange.ApiMarvel.Service.ComicsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marvel")
public class ComicsMController {

    private ComicsService service;

    public ComicsMController(ComicsService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comics")
    public ComicsBaseDto findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comics/{id}")
    public ComicsBaseDto findById(@PathVariable Integer id) {
        return service.findById(id);
    }

}





