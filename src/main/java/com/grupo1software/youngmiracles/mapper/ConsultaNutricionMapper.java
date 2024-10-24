package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.ConsultaNutricionDTO;
import com.grupo1software.youngmiracles.model.entity.ConsultaNutricion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConsultaNutricionMapper {

    private final ModelMapper modelMapper;

    public ConsultaNutricionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ConsultaNutricionDTO toDTO(ConsultaNutricion consultaNutricion) {
        return modelMapper.map(consultaNutricion, ConsultaNutricionDTO.class);
    }

    public ConsultaNutricion toEntity(ConsultaNutricionDTO consultaNutricionDTO) {
        return modelMapper.map(consultaNutricionDTO, ConsultaNutricion.class);
    }
}
