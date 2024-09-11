package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByVoluntarioId(Long voluntarioId);
}
