package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.ConsultaNutricion;
import java.util.List;

public interface ConsultaNutricionService {

    ConsultaNutricion createConsulta(ConsultaNutricion consultaNutricion);

    ConsultaNutricion getConsultaById(Long id);

    List<ConsultaNutricion> getAllConsultas();

    List<ConsultaNutricion> listarConsultasPorAdultoMayor(Long adultoMayorId);

    ConsultaNutricion updateConsulta(Long id, ConsultaNutricion consultaNutricion);

    void deleteConsulta(Long id);
}
