package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.SesionCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.SesionResponseDTO;
import com.grupo1software.youngmiracles.exception.BadRequestException;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.mapper.SesionMapper;
import com.grupo1software.youngmiracles.model.entity.*;
import com.grupo1software.youngmiracles.repository.SesionRepository;
import com.grupo1software.youngmiracles.repository.UsuarioRepository;
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
    private final UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public SesionResponseDTO createSesion(SesionCreateUpdateDTO sesionCreateUpdateDTO) {
        Sesion sesion = sesionMapper.toEntity(sesionCreateUpdateDTO);
        sesion.setFechaRegistro(LocalDateTime.now());
        AdultoMayor adultoMayor= (AdultoMayor) usuarioRepository.findById(sesionCreateUpdateDTO.getAdultoMayorId()).orElseThrow(() -> new ResourceNotFoundException("AdultoMayor no encontrado con el ID: " + sesionCreateUpdateDTO.getAdultoMayorId()));
        Voluntario voluntario= (Voluntario) usuarioRepository.findById(sesionCreateUpdateDTO.getVoluntarioId()).orElseThrow(() -> new ResourceNotFoundException("Voluntario no encontrado con el ID: " + sesionCreateUpdateDTO.getVoluntarioId()));
        sesion.setAdultoMayor(adultoMayor);
        sesion.setVoluntario(voluntario);
        Sesion sesioncreada=sesionRepository.save(sesion);
        System.out.println(sesion);
        return sesionMapper.toDTO(sesioncreada);
    }

    @Transactional(readOnly = true)
    @Override
    public SesionResponseDTO getSesionById(Long id) {
        return sesionMapper.toDTO(sesionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sesion no encontrada con el ID: " + id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<SesionResponseDTO> getAllSesions() {
        return sesionRepository.findAll().stream().map(sesionMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public SesionResponseDTO updateSesion(Long id, SesionCreateUpdateDTO sesionactualizadoDTO) {

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
    public List<SesionResponseDTO> getSesionsByAdultoMayor(Long adultoMayorId) {
        return sesionRepository.findByAdultoMayorId(adultoMayorId).stream().map(sesionMapper::toDTO).toList();
    }


    @Transactional(readOnly = true)
    @Override
    public List<SesionResponseDTO> getSesionsByVoluntario(Long voluntarioId) {
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
