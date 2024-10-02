package com.grupo1software.youngmiracles.repository;
import com.grupo1software.youngmiracles.model.entity.AlertaAdultoMayor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaAdultoMayorRepository extends JpaRepository<AlertaAdultoMayor, Long> {
    List<AlertaAdultoMayor> findByAdultoMayorId(Long adultoMayorId);
}
