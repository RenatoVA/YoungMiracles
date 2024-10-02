package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.model.entity.Capacitaciones;
import com.grupo1software.youngmiracles.repository.CapacitacionesRepository;
import com.grupo1software.youngmiracles.service.CapacitacionesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CapacitacionesServiceImpl implements CapacitacionesService {

    private final CapacitacionesRepository capacitacionesRepository;

    public CapacitacionesServiceImpl(CapacitacionesRepository capacitacionesRepository) {
        this.capacitacionesRepository = capacitacionesRepository;
    }

    @Transactional
    @Override
    public Capacitaciones crearCapacitacion(Capacitaciones capacitacion) {
        return capacitacionesRepository.save(capacitacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Capacitaciones getCapacitacionById(Long id) {
        return capacitacionesRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Capacitaciones> getAllCapacitaciones() {
        return capacitacionesRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Capacitaciones> findByNombreCapacitacion(String nombreCapacitacion) {
        return capacitacionesRepository.findByNombreCapacitacion(nombreCapacitacion);
    }
}
