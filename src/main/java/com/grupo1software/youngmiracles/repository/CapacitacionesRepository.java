package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Capacitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapacitacionesRepository extends JpaRepository<Capacitaciones, Long> {
    List<Capacitaciones> findByNombreCapacitacion(String nombreCapacitacion);
}
