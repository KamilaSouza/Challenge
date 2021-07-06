package orange.ApiMarvel.Repository;

import orange.ApiMarvel.Model.UsersComics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UCRepository extends JpaRepository <UsersComics, Integer> {

    Optional<UsersComics> findById(Integer id);
    UsersComics findByUsersId(Integer id);

    UsersComics getByUsersId(Integer id);

//    List<UsersComics> findByUsersId(Integer id);
}


