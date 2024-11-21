package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("SELECT f FROM Factura f WHERE f.adultoMayor.id = :id")
    List<Factura> findByAdultoMayorId(@Param("id") Long id);
}
