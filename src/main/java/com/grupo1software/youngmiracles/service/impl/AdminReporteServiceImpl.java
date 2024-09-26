package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.ReporteDTO;
import com.grupo1software.youngmiracles.mapper.ReporteMapper;
import com.grupo1software.youngmiracles.model.entity.Mensaje;
import com.grupo1software.youngmiracles.model.entity.Reporte;
import com.grupo1software.youngmiracles.repository.ReporteRepository;
import com.grupo1software.youngmiracles.service.AdminReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminReporteServiceImpl implements AdminReporteService {

    private final ReporteRepository reporteRepository;

    private final ReporteMapper reporteMapper;

    @Transactional
    @Override
    public ReporteDTO createReporte(ReporteDTO reporte) {
        Reporte nuevoreporte = reporteMapper.toEntity(reporte);
        nuevoreporte.setFecha(LocalDateTime.now());
        return reporteMapper.toDTO(reporteRepository.save(nuevoreporte));
    }

    @Transactional
    @Override
    public ReporteDTO updateReporte(Long Id,ReporteDTO reporteDTO) {
        Reporte reporteexistente=reporteRepository.findById(Id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + Id));
        Reporte reporte=reporteMapper.toEntity(reporteDTO);
        reporteexistente.setDescripcion(reporte.getDescripcion());
        return reporteMapper.toDTO(reporteRepository.save(reporteexistente));
    }

    @Transactional(readOnly = true)
    @Override
    public ReporteDTO getReporteById(Long id) {
        return reporteMapper.toDTO(reporteRepository.findById(id).orElse(null));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReporteDTO> getAllReportes() {
        return reporteRepository.findAll().stream().map(reporteMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReporteDTO> getReporteByAdultoMayor(Long id) {
        return reporteRepository.findByAdultoMayorId(id).stream().map(reporteMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReporteDTO> getReporteByVoluntario(Long id) {
        return reporteRepository.findByVoluntarioId(id).stream().map(reporteMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public void deleteReporte(Long id) {
        reporteRepository.deleteById(id);

    }
}
