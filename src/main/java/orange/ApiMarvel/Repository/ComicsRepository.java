package orange.ApiMarvel.Repository;

import orange.ApiMarvel.Model.Comics;
import orange.ApiMarvel.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicsRepository extends JpaRepository <Comics, Integer> {

    Comics findByTitle(String title);

    Comics findByComicId(Integer comicId);

}
