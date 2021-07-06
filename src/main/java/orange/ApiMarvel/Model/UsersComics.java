package orange.ApiMarvel.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UsersComics {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Users users;

    @ManyToMany
    private List<Comics> comics;

    public UsersComics(){
    }

    public UsersComics(String email, String title) {

    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Comics> getComics() {
        return comics;
    }

    public void setComics(List<Comics> comics) {
        this.comics = comics;
    }
}
