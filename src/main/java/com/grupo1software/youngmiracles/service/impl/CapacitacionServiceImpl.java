package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.CapacitacionDTO;
import com.grupo1software.youngmiracles.model.entity.Capacitacion;
import com.grupo1software.youngmiracles.repository.CapacitacionRepository;
import com.grupo1software.youngmiracles.service.CapacitacionService;
import com.grupo1software.youngmiracles.mapper.CapacitacionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CapacitacionServiceImpl implements CapacitacionService {

    private final CapacitacionRepository capacitacionRepository;
    private final CapacitacionMapper capacitacionMapper;

    @Transactional(readOnly = true)
    @Override
    public List<CapacitacionDTO> getAllCapacitaciones() {
        return capacitacionRepository.findAll().stream()
                .map(capacitacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public CapacitacionDTO getCapacitacionById(Long id) {
        return capacitacionRepository.findById(id)
                .map(capacitacionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Capacitación no encontrada"));
    }

    @Transactional
    @Override
    public CapacitacionDTO createCapacitacion(CapacitacionDTO capacitacionDTO) {
        Capacitacion capacitacion = capacitacionMapper.toEntity(capacitacionDTO);
        return capacitacionMapper.toDTO(capacitacionRepository.save(capacitacion));
    }

    @Transactional
    @Override
    public CapacitacionDTO updateCapacitacion(Long id, CapacitacionDTO capacitacionDTO) {
        Capacitacion capacitacion = capacitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Capacitación no encontrada"));
        capacitacion.setTitulo(capacitacionDTO.getTitulo());
        capacitacion.setDescripcion(capacitacionDTO.getDescripcion());
        capacitacion.setContenido(capacitacionDTO.getContenido());
        return capacitacionMapper.toDTO(capacitacionRepository.save(capacitacion));
    }

    @Transactional
    @Override
    public void deleteCapacitacion(Long id) {
        capacitacionRepository.deleteById(id);
    }
}
