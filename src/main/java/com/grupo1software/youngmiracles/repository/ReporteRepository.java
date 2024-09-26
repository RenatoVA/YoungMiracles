package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {
    List<Reporte> findByAdultoMayorId(Long id);
    List<Reporte> findByVoluntarioId(Long id);
}
