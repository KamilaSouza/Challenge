package orange.ApiMarvel.Controller.Feign;


import orange.ApiMarvel.Controller.Dto.ComicsBaseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marvel", url = "${url.marvel}/v1/public")
public interface ComicsFeign {

    @GetMapping("/comics")
    public ComicsBaseDto getAll(@RequestParam(value = "ts") Long timeStamp,
                                @RequestParam(value = "apikey") String publicKey,
                                @RequestParam(value = "hash") String hashMD5);

    @GetMapping("/comics/{id}")
    public ComicsBaseDto getById(@PathVariable Integer id,
                                @RequestParam(value = "ts") Long timeStamp,
                                @RequestParam(value = "apikey") String publicKey,
                                @RequestParam(value = "hash") String hashMD5

    );

}








