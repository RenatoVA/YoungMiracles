package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.ReporteDTO;
import java.util.List;

public interface ReporteService {
    List<ReporteDTO> getAllReportes();
    ReporteDTO getReporteById(Long id);
    ReporteDTO createReporte(ReporteDTO reporteDTO);
    ReporteDTO updateReporte(Long id, ReporteDTO reporteDTO);
    void deleteReporte(Long id);
}
