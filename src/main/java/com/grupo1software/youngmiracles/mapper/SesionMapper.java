package com.grupo1software.youngmiracles.mapper;


import com.grupo1software.youngmiracles.dto.*;
import com.grupo1software.youngmiracles.model.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SesionMapper {

    private final ModelMapper modelMapper;

    public SesionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.typeMap(Fisioterapia.class, FisioterapiaDTO.class);
        this.modelMapper.typeMap(FisioterapiaDTO.class, Fisioterapia.class);

        this.modelMapper.typeMap(Taller.class, TallerDTO.class);
        this.modelMapper.typeMap(TallerDTO.class, Taller.class);

        this.modelMapper.typeMap(Nutricion.class, NutricionDTO.class);
        this.modelMapper.typeMap(NutricionDTO.class, Nutricion.class);
    }
    public SesionDTO toDTO(Sesion sesion) {
        if(sesion instanceof Fisioterapia){
            return modelMapper.map(sesion, FisioterapiaDTO.class);
        }else if (sesion instanceof Taller){
            return modelMapper.map(sesion, TallerDTO.class);
        }
        else if (sesion instanceof Nutricion){
            return modelMapper.map(sesion, NutricionDTO.class);
        }else {
            throw new IllegalArgumentException("Tipo de sesion no soportado");
        }
    }
    public Sesion toEntity(SesionDTO sesionDTO) {
        if(sesionDTO instanceof FisioterapiaDTO){
            return modelMapper.map(sesionDTO, Fisioterapia.class);
        }else if (sesionDTO instanceof TallerDTO){
            return modelMapper.map(sesionDTO, Taller.class);
        }else if (sesionDTO instanceof NutricionDTO){
            return modelMapper.map(sesionDTO, Nutricion.class);
        }else{
            throw new IllegalArgumentException("Tipo de sesion no soportado");
        }
    }

}
