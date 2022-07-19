package pl.sda.Projekt_Koncowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.Projekt_Koncowy.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
