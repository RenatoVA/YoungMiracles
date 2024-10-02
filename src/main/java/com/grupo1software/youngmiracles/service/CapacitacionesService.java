package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Capacitaciones;

import java.util.List;

public interface CapacitacionesService {
    Capacitaciones crearCapacitacion(Capacitaciones capacitacion);
    Capacitaciones getCapacitacionById(Long id);
    List<Capacitaciones> getAllCapacitaciones();
    List<Capacitaciones> findByNombreCapacitacion(String nombreCapacitacion);
}
