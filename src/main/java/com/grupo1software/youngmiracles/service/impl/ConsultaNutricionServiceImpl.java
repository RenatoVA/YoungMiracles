package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.model.entity.ConsultaNutricion;
import com.grupo1software.youngmiracles.repository.ConsultaNutricionRepository;
import com.grupo1software.youngmiracles.service.ConsultaNutricionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ConsultaNutricionServiceImpl implements ConsultaNutricionService {
    private final ConsultaNutricionRepository consultaNutricionRepository;

    @Transactional
    @Override
    public ConsultaNutricion createConsulta(ConsultaNutricion consultaNutricion) {
        return consultaNutricionRepository.save(consultaNutricion);
    }

    @Transactional(readOnly = true)
    @Override
    public ConsultaNutricion getConsultaById(Long id) {
        return consultaNutricionRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ConsultaNutricion> getAllConsultas() {
        return consultaNutricionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ConsultaNutricion> listarConsultasPorAdultoMayor(Long adultoMayorId) {
        return consultaNutricionRepository.findByAdultoMayorId(adultoMayorId);
    }

    @Transactional
    @Override
    public ConsultaNutricion updateConsulta(Long id, ConsultaNutricion consultaNutricion) {
        ConsultaNutricion consultaExistente = consultaNutricionRepository.findById(id).orElse(null);
        if (consultaExistente != null) {
            consultaExistente.setFechaConsulta(consultaNutricion.getFechaConsulta());
            consultaExistente.setCondicionSalud(consultaNutricion.getCondicionSalud());
            consultaExistente.setRecomendaciones(consultaNutricion.getRecomendaciones());
            return consultaNutricionRepository.save(consultaExistente);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteConsulta(Long id) {
        consultaNutricionRepository.deleteById(id);
    }


}
