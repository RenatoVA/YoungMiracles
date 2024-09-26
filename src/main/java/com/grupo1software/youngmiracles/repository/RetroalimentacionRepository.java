package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Retroalimentacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RetroalimentacionRepository extends JpaRepository<Retroalimentacion, Long> {
    List<Retroalimentacion> findByVoluntarioId(Long voluntarioId);
}
