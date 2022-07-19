package pl.sda.Projekt_Koncowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.Projekt_Koncowy.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

}
