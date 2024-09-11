package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
