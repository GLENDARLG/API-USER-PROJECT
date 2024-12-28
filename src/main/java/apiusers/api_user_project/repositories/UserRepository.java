package apiusers.api_user_project.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import apiusers.api_user_project.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
