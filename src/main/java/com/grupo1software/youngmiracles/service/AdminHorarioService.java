package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.CreateUpdateHorarioDTO;
import com.grupo1software.youngmiracles.dto.HorarioResponseDTO;
import com.grupo1software.youngmiracles.model.entity.Horario;

import java.util.List;

public interface AdminHorarioService {
    HorarioResponseDTO createHorario(CreateUpdateHorarioDTO horario);
    HorarioResponseDTO getHorarioById(Long id);
    List<HorarioResponseDTO> getAllHorarios();
    List<HorarioResponseDTO> getHorariosByVoluntario(Long voluntarioId);
    List<HorarioResponseDTO> getHorariosByespecialidad(String especialidad);
    HorarioResponseDTO updateHorario(Long id, CreateUpdateHorarioDTO horario);
    void deleteHorario(Long id);
}
