package is.technologies.Interfaces.JpaRepositories;

import is.technologies.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByName(String name);
}
