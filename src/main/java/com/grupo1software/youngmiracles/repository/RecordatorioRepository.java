package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Recordatorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {
    List<Recordatorio> findByUsuarioId(Long usuarioId);
}
