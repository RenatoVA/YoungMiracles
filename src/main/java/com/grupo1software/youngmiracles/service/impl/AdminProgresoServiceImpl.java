package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.model.entity.Progreso;
import com.grupo1software.youngmiracles.repository.ProgresoRepository;
import com.grupo1software.youngmiracles.service.AdminProgresoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminProgresoServiceImpl implements AdminProgresoService {
    private final ProgresoRepository progresoRepository;


    @Transactional
    @Override
    public Progreso createProgreso(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    @Transactional(readOnly = true)
    @Override
    public Progreso getProgresoById(Long id) {
        return progresoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Progreso no encontrada con el ID: " + id));}

    @Transactional(readOnly = true)
    @Override
    public List<Progreso> getAllProgresos() {
        return progresoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Progreso> getProgresosBySesion(Long sesionId) {
        return progresoRepository.findBySesionId(sesionId);
    }

    @Transactional
    @Override
    public Progreso updateProgreso(Long id, Progreso progreso) {
        Progreso p = progresoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Progreso no encontrada con el ID: " + id));
            p.setSesion(progreso.getSesion());
            p.setFecha(progreso.getFecha());
            p.setEstado(progreso.getEstado());
            return progresoRepository.save(p);
    }

    @Transactional
    @Override
    public void deleteProgreso(Long id) {
        progresoRepository.deleteById(id);
    }
}
