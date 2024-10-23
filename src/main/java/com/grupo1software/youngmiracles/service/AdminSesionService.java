package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.SesionCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.SesionResponseDTO;

import java.util.List;

public interface AdminSesionService {
    SesionResponseDTO createSesion(SesionCreateUpdateDTO sessionDTO);
    SesionResponseDTO getSesionById(Long id);
    List<SesionResponseDTO> getAllSesions();
    SesionResponseDTO updateSesion(Long id, SesionCreateUpdateDTO sessionDTO);
    void deleteSesion(Long id);
    List<SesionResponseDTO> getSesionsByAdultoMayor(Long adultoMayorId);
    List<SesionResponseDTO> getSesionsByVoluntario(Long voluntarioId);
}
