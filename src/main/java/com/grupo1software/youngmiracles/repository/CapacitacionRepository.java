package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Long> {
}
