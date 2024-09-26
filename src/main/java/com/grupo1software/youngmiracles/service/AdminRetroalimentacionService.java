package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.RetroalimentacionDTO;

import java.util.List;

public interface AdminRetroalimentacionService {
    RetroalimentacionDTO createRetroalimentacion(RetroalimentacionDTO retroalimentacionDTO);
    RetroalimentacionDTO getRetroalimentacionById(Long Id);
    RetroalimentacionDTO updateRetroalimentacion(Long Id,RetroalimentacionDTO retroalimentacionDTO);
    List<RetroalimentacionDTO> getRetroalimentacionesByVoluntario(Long voluntarioId);
    void deleteRetroalimentacion(Long Id);
}
