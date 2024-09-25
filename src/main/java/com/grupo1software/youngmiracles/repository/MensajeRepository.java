package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

}
