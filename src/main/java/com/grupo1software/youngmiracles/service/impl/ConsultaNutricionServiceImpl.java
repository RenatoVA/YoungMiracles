package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.ConsultaNutricionDTO;
import com.grupo1software.youngmiracles.mapper.ConsultaNutricionMapper;
import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.ConsultaNutricion;
import com.grupo1software.youngmiracles.repository.ConsultaNutricionRepository;
import com.grupo1software.youngmiracles.service.ConsultaNutricionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultaNutricionServiceImpl implements ConsultaNutricionService {

    private final ConsultaNutricionRepository consultaNutricionRepository;
    private final ConsultaNutricionMapper consultaNutricionMapper;

    @Transactional
    @Override
    public ConsultaNutricionDTO crearConsulta(ConsultaNutricionDTO consultaNutricionDTO) {
        ConsultaNutricion consulta = consultaNutricionMapper.toEntity(consultaNutricionDTO);
        ConsultaNutricion savedConsulta = consultaNutricionRepository.save(consulta);
        return consultaNutricionMapper.toDTO(savedConsulta);
    }

    @Transactional(readOnly = true)
    @Override
    public ConsultaNutricionDTO getConsultaById(Long id) {
        ConsultaNutricion consulta = consultaNutricionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta no encontrada"));
        return consultaNutricionMapper.toDTO(consulta);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ConsultaNutricionDTO> getAllConsultas() {
        List<ConsultaNutricion> consultas = consultaNutricionRepository.findAll();
        return consultas.stream().map(consultaNutricionMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ConsultaNutricionDTO> listarConsultasPorAdultoMayor(Long adultoMayorId) {
        List<ConsultaNutricion> consultas = consultaNutricionRepository.findByAdultoMayorId(adultoMayorId);
        return consultas.stream().map(consultaNutricionMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ConsultaNutricionDTO updateConsulta(Long id, ConsultaNutricionDTO consultaNutricionDTO) {
        ConsultaNutricion consultaExistente = consultaNutricionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta no encontrada"));

        consultaExistente.setFechaConsulta(consultaNutricionDTO.getFechaConsulta());
        consultaExistente.setCondicionSalud(consultaNutricionDTO.getCondicionSalud());
        consultaExistente.setRecomendaciones(consultaNutricionDTO.getRecomendaciones());
        consultaExistente.setAdultoMayor(new AdultoMayor(consultaNutricionDTO.getAdultoMayorId()));

        ConsultaNutricion updatedConsulta = consultaNutricionRepository.save(consultaExistente);
        return consultaNutricionMapper.toDTO(updatedConsulta);
    }
}
