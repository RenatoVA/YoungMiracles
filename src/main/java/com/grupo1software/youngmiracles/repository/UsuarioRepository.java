package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Usuario;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
    Optional<Usuario> findByCorreo(String correo);
    @Query("SELECT v FROM Voluntario v WHERE v.especialidad = :especialidad")
    List<Voluntario> findVoluntariosByEspecialidad(@Param("especialidad") String especialidad);
}