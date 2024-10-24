package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.ConsultaNutricion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsultaNutricionRepository extends JpaRepository<ConsultaNutricion, Long> {
    List<ConsultaNutricion> findByAdultoMayorId(Long adultoMayorId);
}
