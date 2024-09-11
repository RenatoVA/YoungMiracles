package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.model.entity.Fisioterapia;
import com.grupo1software.youngmiracles.model.entity.Sesion;
import com.grupo1software.youngmiracles.model.entity.Taller;
import com.grupo1software.youngmiracles.repository.SesionRepository;
import com.grupo1software.youngmiracles.service.AdminSesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminSesionServiceImpl implements AdminSesionService {

    private final SesionRepository sesionRepository;

    @Transactional
    @Override
    public Sesion createSesion(Sesion sesion) {
        if (sesion instanceof Fisioterapia) {
            return createFisioterapia((Fisioterapia) sesion);
        } else if (sesion instanceof Taller) {
            return createTaller((Taller) sesion);
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Sesion getSesionById(Long id) {
        return sesionRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sesion> getAllSesions() {
        return sesionRepository.findAll();
    }

    @Transactional
    @Override
    public Sesion updateSesion(Long id, Sesion sesionactualizado) {
        Sesion sesion = sesionRepository.findById(id).orElse(null);
        if (sesion != null) {
            sesion.setFecha(sesionactualizado.getFecha());
            sesion.setEstado(sesionactualizado.getEstado());
            sesion.setDuracion(sesionactualizado.getDuracion());
            sesion.setVoluntario(sesionactualizado.getVoluntario());
            sesion.setAdultoMayor(sesionactualizado.getAdultoMayor());
            sesion.setDuracion(sesionactualizado.getDuracion());
            switch (sesion) {
                case Fisioterapia fisioterapia when sesionactualizado instanceof Fisioterapia ->
                    updateFisioterapia(fisioterapia, (Fisioterapia) sesionactualizado);
                case Taller taller when sesionactualizado instanceof Taller ->
                    updateTaller(taller, (Taller) sesionactualizado);
                default -> {
                }
            }
            return sesionRepository.save(sesion);

        }
        return null;
    }

    @Transactional
    @Override
    public void deleteSesion(Long id) {
        sesionRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sesion> getSesionsByAdultoMayor(Long adultoMayorId) {
        return sesionRepository.findByAdultoMayorId(adultoMayorId);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Sesion> getSesionsByVoluntario(Long voluntarioId) {
        return sesionRepository.findByVoluntarioId(voluntarioId);
    }
    private Sesion createFisioterapia(Sesion sesion) {
        if (sesion instanceof Fisioterapia) {
            sesion.setFechaRegistro(LocalDateTime.now());
            return sesionRepository.save(sesion);
        }
        throw new IllegalArgumentException("La sesion debe ser fisioterapia");
    }

    private Sesion createTaller(Sesion sesion) {
        if (sesion instanceof Taller) {
            sesion.setFechaRegistro(LocalDateTime.now());
            return sesionRepository.save(sesion);

        }
        throw new IllegalArgumentException("La sesion debe ser taller");
    }

    private void updateFisioterapia(Fisioterapia fisioterapia, Fisioterapia details) {
        fisioterapia.setTipoFisioterapia(details.getTipoFisioterapia());
        fisioterapia.setObservaciones(details.getObservaciones());
    }

    private void updateTaller(Taller taller, Taller details) {
        taller.setDescripcion(details.getDescripcion());
        taller.setCapacidadMaxima(details.getCapacidadMaxima());
        taller.setMaterialRequerido(details.getMaterialRequerido());
    }

}
