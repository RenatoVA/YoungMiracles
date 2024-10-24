package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.RecetasDTO;
import com.grupo1software.youngmiracles.model.entity.Recetas;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RecetasMapper {

    private final ModelMapper modelMapper;

    public RecetasMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RecetasDTO toDto(Recetas receta) {
        return modelMapper.map(receta, RecetasDTO.class);
    }

    public Recetas toEntity(RecetasDTO recetaDTO) {
        return modelMapper.map(recetaDTO, Recetas.class);
    }
}

