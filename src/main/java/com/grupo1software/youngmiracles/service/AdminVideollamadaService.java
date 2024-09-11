package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Videollamada;

import java.util.List;

public interface AdminVideollamadaService {
    Videollamada createVideollamada(Videollamada videollamada);
    Videollamada getVideollamadaById(Long id);
    List<Videollamada> getAllVideollamadas();
    Videollamada updateVideollamada(Long id, Videollamada videollamada);
    void deleteVideollamada(Long id);
    List<Videollamada> getVideollamadasByAdultoMayor(Long adultoMayorId);
    List<Videollamada> getVideollamadasByVoluntario(Long voluntarioId);
}
