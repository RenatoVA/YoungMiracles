package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.ReporteDTO;
import com.grupo1software.youngmiracles.model.entity.Reporte;
import com.grupo1software.youngmiracles.repository.ReporteRepository;
import com.grupo1software.youngmiracles.service.ReporteService;
import com.grupo1software.youngmiracles.mapper.ReporteMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;
    private final ReporteMapper reporteMapper;
    private static final Logger logger = LoggerFactory.getLogger(ReporteServiceImpl.class);

    @Transactional(readOnly = true)
    @Override
    public List<ReporteDTO> getAllReportes() {
        logger.info("Fetching all reports");
        return reporteRepository.findAll().stream()
                .map(reporteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public ReporteDTO getReporteById(Long id) {
        logger.info("Fetching report with id {}", id);
        return reporteRepository.findById(id)
                .map(reporteMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    @Transactional
    @Override
    public ReporteDTO createReporte(ReporteDTO reporteDTO) {
        logger.info("Creating report with description: {}", reporteDTO.getDescripcion());
        Reporte reporte = reporteMapper.toEntity(reporteDTO);
        return reporteMapper.toDTO(reporteRepository.save(reporte));
    }

    @Transactional
    @Override
    public ReporteDTO updateReporte(Long id, ReporteDTO reporteDTO) {
        logger.info("Updating report with id {}", id);
        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
        reporte.setDescripcion(reporteDTO.getDescripcion());
        reporte.setProgreso(reporteDTO.getProgreso());
        return reporteMapper.toDTO(reporteRepository.save(reporte));
    }

    @Transactional
    @Override
    public void deleteReporte(Long id) {
        logger.info("Deleting report with id {}", id);
        reporteRepository.deleteById(id);
    }
}


