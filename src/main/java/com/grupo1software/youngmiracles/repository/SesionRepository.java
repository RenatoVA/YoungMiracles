package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
    List<Sesion> findByAdultoMayorId(Long adultoMayorId);
    List<Sesion> findByVoluntarioId(Long voluntarioId);
}
