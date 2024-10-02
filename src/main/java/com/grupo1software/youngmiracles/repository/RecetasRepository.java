package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Recetas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetasRepository extends JpaRepository<Recetas,Long> {
    List<Recetas> findByNombreReceta(String nombreReceta);
}
