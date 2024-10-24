package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.ConsultaNutricionDTO;
import java.util.List;

public interface ConsultaNutricionService {
    ConsultaNutricionDTO crearConsulta(ConsultaNutricionDTO consultaNutricionDTO);
    ConsultaNutricionDTO getConsultaById(Long id);
    List<ConsultaNutricionDTO> getAllConsultas();
    List<ConsultaNutricionDTO> listarConsultasPorAdultoMayor(Long adultoMayorId);
    ConsultaNutricionDTO updateConsulta(Long id, ConsultaNutricionDTO consultaNutricionDTO);
}
