package app.springboot.gamestracker.repository;

import app.springboot.gamestracker.dto.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}