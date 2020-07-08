package ru.khaustov.coursediplom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khaustov.coursediplom.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
