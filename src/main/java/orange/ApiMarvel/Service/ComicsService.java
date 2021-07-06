package orange.ApiMarvel.Service;

import orange.ApiMarvel.Controller.Dto.ComicsBaseDto;
import orange.ApiMarvel.Controller.Feign.ComicsFeign;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.Date;

@Service
public class ComicsService {

    private static final String PUBLIC_KEY = "8750b81f398c652ed980eb60862a05df";
    private static final String PRIVATE_KEY = "875e92a046a6480b8e39f84c0b81f5d1daf18b4c";

    private ComicsFeign comics;

    public ComicsService(ComicsFeign comics) {
        this.comics = comics;
    }

    public ComicsBaseDto findAll() {
        Long timeStamp = new Date().getTime();

        return comics.getAll(timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }

    public ComicsBaseDto findById(Integer comic) {
        Long timeStamp = new Date().getTime();

        return comics.getById(comic, timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }

    private String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + PRIVATE_KEY + PUBLIC_KEY);
    }

}

