package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.ReporteVoluntarioResponseDTO;
import com.grupo1software.youngmiracles.dto.SesionCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.SesionResponseDTO;
import com.grupo1software.youngmiracles.dto.SesionUpdateStateDTO;

import java.util.List;

public interface AdminSesionService {
    SesionResponseDTO createSesion(SesionCreateUpdateDTO sessionDTO);
    SesionResponseDTO getSesionById(Long id);
    List<SesionResponseDTO> getAllSesions();
    SesionResponseDTO updateSesion(Long id, SesionCreateUpdateDTO sessionDTO);
    void deleteSesion(Long id);
    ReporteVoluntarioResponseDTO generarReportePorVoluntario(Long id);
    void updateSesionState(SesionUpdateStateDTO sesionUpdateStateDTO);
    List<SesionResponseDTO> getSesionsByAdultoMayor(Long adultoMayorId);
    List<SesionResponseDTO> getSesionsByVoluntario(Long voluntarioId);
}
