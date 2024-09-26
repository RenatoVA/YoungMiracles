package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.ReporteDTO;
import com.grupo1software.youngmiracles.model.entity.Reporte;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReporteMapper {
    private final ModelMapper modelMapper;

    public ReporteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ReporteDTO toDTO(Reporte reporte) {
        return modelMapper.map(reporte, ReporteDTO.class);
    }
    public Reporte toEntity(ReporteDTO reporteDTO) {
        return modelMapper.map(reporteDTO, Reporte.class);
    }
}
