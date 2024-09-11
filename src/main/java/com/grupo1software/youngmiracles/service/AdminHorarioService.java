package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Horario;

import java.util.List;

public interface AdminHorarioService {
    Horario createHorario(Horario horario);
    Horario getHorarioById(Long id);
    List<Horario> getAllHorarios();
    List<Horario> getHorariosByVoluntario(Long voluntarioId);
    Horario updateHorario(Long id, Horario horario);
    void deleteHorario(Long id);
}
