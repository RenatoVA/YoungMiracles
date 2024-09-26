package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.ReporteDTO;

import java.util.List;

public interface AdminReporteService {
    ReporteDTO createReporte(ReporteDTO reporte);
    ReporteDTO updateReporte(Long Id,ReporteDTO reporte);
    ReporteDTO getReporteById(Long id);
    List<ReporteDTO> getAllReportes();
    List<ReporteDTO> getReporteByAdultoMayor(Long id);
    List<ReporteDTO> getReporteByVoluntario(Long id);
    void deleteReporte(Long id);
}
