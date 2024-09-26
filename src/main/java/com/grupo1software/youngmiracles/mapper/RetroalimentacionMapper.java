package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.RetroalimentacionDTO;
import com.grupo1software.youngmiracles.model.entity.Retroalimentacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RetroalimentacionMapper {
    private final ModelMapper modelMapper;

    public RetroalimentacionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public RetroalimentacionDTO toDTO(Retroalimentacion retroalimentacion) {
        return modelMapper.map(retroalimentacion, RetroalimentacionDTO.class);
    }
    public Retroalimentacion toEntity(RetroalimentacionDTO retroalimentacionDTO) {
        return modelMapper.map(retroalimentacionDTO, Retroalimentacion.class);
    }
}
