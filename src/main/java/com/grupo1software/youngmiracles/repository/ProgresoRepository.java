package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgresoRepository extends JpaRepository<Progreso, Long> {
    List<Progreso> findBySesionId(Long sesionId);
}
