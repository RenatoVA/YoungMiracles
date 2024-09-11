package com.grupo1software.youngmiracles.repository;


import com.grupo1software.youngmiracles.model.entity.Videollamada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideollamadaRepository extends JpaRepository<Videollamada, Long> {
    List<Videollamada> findByAdultoMayorId(Long adultoMayorId);
    List<Videollamada> findByVoluntarioId(Long voluntarioId);
}
