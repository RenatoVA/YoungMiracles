package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.SesionDTO;
import com.grupo1software.youngmiracles.model.entity.Sesion;

import java.util.List;

public interface AdminSesionService {
    SesionDTO createSesion(SesionDTO sessionDTO);
    SesionDTO getSesionById(Long id);
    List<SesionDTO> getAllSesions();
    SesionDTO updateSesion(Long id, SesionDTO sessionDTO);
    void deleteSesion(Long id);
    List<SesionDTO> getSesionsByAdultoMayor(Long adultoMayorId);
    List<SesionDTO> getSesionsByVoluntario(Long voluntarioId);
}
