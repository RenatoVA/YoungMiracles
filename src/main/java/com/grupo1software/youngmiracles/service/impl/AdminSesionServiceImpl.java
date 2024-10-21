package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.SesionDTO;
import com.grupo1software.youngmiracles.exception.BadRequestException;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.mapper.SesionMapper;
import com.grupo1software.youngmiracles.model.entity.Fisioterapia;
import com.grupo1software.youngmiracles.model.entity.Nutricion;
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

    private final SesionMapper sesionMapper;

    @Transactional
    @Override
    public SesionDTO createSesion(SesionDTO sesionDTO) {
        Sesion sesion = sesionMapper.toEntity(sesionDTO);
        sesion.setFechaRegistro(LocalDateTime.now());
        Sesion sesioncreada=sesionRepository.save(sesion);
        return sesionMapper.toDTO(sesioncreada);

    }

    @Transactional(readOnly = true)
    @Override
    public SesionDTO getSesionById(Long id) {
        return sesionMapper.toDTO(sesionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sesion no encontrada con el ID: " + id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<SesionDTO> getAllSesions() {
        return sesionRepository.findAll().stream().map(sesionMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public SesionDTO updateSesion(Long id, SesionDTO sesionactualizadoDTO) {

        Sesion sesionexistente=sesionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sesion no encontrado con el ID: " + id));


        Sesion sesionactualizado=sesionMapper.toEntity(sesionactualizadoDTO);

        sesionexistente.setFecha(sesionactualizado.getFecha());
        sesionexistente.setEstado(sesionactualizado.getEstado());
        sesionexistente.setDuracion(sesionactualizado.getDuracion());
        sesionexistente.setVoluntario(sesionactualizado.getVoluntario());
        sesionexistente.setAdultoMayor(sesionactualizado.getAdultoMayor());
        sesionexistente.setDuracion(sesionactualizado.getDuracion());

        switch (sesionexistente){
            case Fisioterapia fisioterapia when sesionactualizado instanceof Fisioterapia ->
                    updateFisioterapia(fisioterapia, (Fisioterapia) sesionactualizado);
            case Taller taller when sesionactualizado instanceof Taller ->
                    updateTaller(taller, (Taller) sesionactualizado);
            case Nutricion nutricion when sesionactualizado instanceof Nutricion ->
                    updateNutricion(nutricion, (Nutricion) sesionactualizado);
            default -> throw new BadRequestException("Tipo de sesion no soportado");

        }

        return sesionMapper.toDTO(sesionRepository.save(sesionexistente));
    }

    @Transactional
    @Override
    public void deleteSesion(Long id) {
        sesionRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SesionDTO> getSesionsByAdultoMayor(Long adultoMayorId) {
        return sesionRepository.findByAdultoMayorId(adultoMayorId).stream().map(sesionMapper::toDTO).toList();
    }


    @Transactional(readOnly = true)
    @Override
    public List<SesionDTO> getSesionsByVoluntario(Long voluntarioId) {
        return sesionRepository.findByVoluntarioId(voluntarioId).stream().map(sesionMapper::toDTO).toList();
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
    private void updateNutricion(Nutricion nutricion, Nutricion details) {
        nutricion.setIndicaciones(details.getIndicaciones());
        nutricion.setReceta(details.getReceta());
    }

}
