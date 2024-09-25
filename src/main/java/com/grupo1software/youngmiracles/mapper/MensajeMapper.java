package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.MensajeDTO;
import com.grupo1software.youngmiracles.model.entity.Mensaje;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MensajeMapper {
    private final ModelMapper modelMapper;
    public MensajeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public MensajeDTO toDTO(Mensaje mensaje) {
        return modelMapper.map(mensaje, MensajeDTO.class);
    }
    public Mensaje toEntity(MensajeDTO mensajeDTO) {
        return modelMapper.map(mensajeDTO, Mensaje.class);
    }
}
