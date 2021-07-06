package orange.ApiMarvel.Controller.Form;

import orange.ApiMarvel.Model.Comics;
import orange.ApiMarvel.Model.UsersComics;
import orange.ApiMarvel.Model.Users;
import orange.ApiMarvel.Repository.ComicsRepository;
import orange.ApiMarvel.Repository.UserRepository;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class UCForm {

    @NotBlank
    private String email;

    private List<String> title;

    public UsersComics convertUserComics(UserRepository userRepository, ComicsRepository comicsRepository) {
        Users users = userRepository.findByEmail(email);
        List<String> titulos = new ArrayList<>();
        int i;

        for (i = 0; i < title.size() - 1; i++) {
            Comics comic = comicsRepository.findByTitle(title.get(i));
            titulos.add(title.get(i));
        }
        return new UsersComics(email, title.get(i));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }
}
