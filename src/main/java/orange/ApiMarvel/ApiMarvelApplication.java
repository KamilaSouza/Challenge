package orange.ApiMarvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiMarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMarvelApplication.class, args);
	}

}



















