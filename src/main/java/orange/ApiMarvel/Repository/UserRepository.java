package orange.ApiMarvel.Repository;

import orange.ApiMarvel.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);

    Optional<Users> findById(Integer id);
}
