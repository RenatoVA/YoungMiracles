package com.grupo1software.youngmiracles.repository;

import com.grupo1software.youngmiracles.model.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
