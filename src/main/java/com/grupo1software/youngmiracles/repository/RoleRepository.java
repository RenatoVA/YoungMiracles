package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Role;
import com.grupo1software.youngmiracles.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNombre(ERole nombre);
}
