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
    public SesionResponseDTO toDTO(Sesion sesion) {
        if(sesion instanceof Fisioterapia){
            FisioterapiaResponseDTO  fisioterapiaDTO = new FisioterapiaResponseDTO();
            fisioterapiaDTO.setId(sesion.getId());
            fisioterapiaDTO.setTipoFisioterapia(((Fisioterapia) sesion).getTipoFisioterapia());
            fisioterapiaDTO.setObservaciones(((Fisioterapia) sesion).getObservaciones());
            fisioterapiaDTO.setFecha(sesion.getFecha());
            fisioterapiaDTO.setDuracion(sesion.getDuracion());
            fisioterapiaDTO.setEstado(sesion.getEstado());
            fisioterapiaDTO.setAdultomayorId(sesion.getAdultoMayor().getId());
            fisioterapiaDTO.setVoluntarioId(sesion.getVoluntario().getId());
            return fisioterapiaDTO;
        }else if (sesion instanceof Taller){
            TallerResponseDTO tallerResponseDTO= new TallerResponseDTO();
            tallerResponseDTO.setId(sesion.getId());
            tallerResponseDTO.setDuracion(sesion.getDuracion());
            tallerResponseDTO.setEstado(sesion.getEstado());
            tallerResponseDTO.setFecha(sesion.getFecha());
            tallerResponseDTO.setAdultomayorId(sesion.getAdultoMayor().getId());
            tallerResponseDTO.setVoluntarioId(sesion.getVoluntario().getId());
            tallerResponseDTO.setCapacidadMaxima(((Taller) sesion).getCapacidadMaxima());
            tallerResponseDTO.setDescripcion(((Taller) sesion).getDescripcion());
            tallerResponseDTO.setMaterialRequerido(((Taller) sesion).getMaterialRequerido());
            return tallerResponseDTO;
        }
        else if (sesion instanceof Nutricion){
            NutricionResponseDTO nutricionResponseDTO= new NutricionResponseDTO();
            nutricionResponseDTO.setId(sesion.getId());
            nutricionResponseDTO.setDuracion(sesion.getDuracion());
            nutricionResponseDTO.setEstado(sesion.getEstado());
            nutricionResponseDTO.setFecha(sesion.getFecha());
            nutricionResponseDTO.setAdultomayorId(sesion.getAdultoMayor().getId());
            nutricionResponseDTO.setVoluntarioId(sesion.getVoluntario().getId());
            nutricionResponseDTO.setIndicaciones(((Nutricion) sesion).getIndicaciones());
            nutricionResponseDTO.setReceta(((Nutricion) sesion).getReceta());
            return nutricionResponseDTO;
        }else {
            throw new IllegalArgumentException("Tipo de sesion no soportado");
        }
    }
    public Sesion toEntity(SesionCreateUpdateDTO sesionCreateUpdateDTO) {
        if(sesionCreateUpdateDTO instanceof FisioterapiaDTO){
            return modelMapper.map(sesionCreateUpdateDTO, Fisioterapia.class);
        }else if (sesionCreateUpdateDTO instanceof TallerDTO){
            return modelMapper.map(sesionCreateUpdateDTO, Taller.class);
        }else if (sesionCreateUpdateDTO instanceof NutricionDTO){
            return modelMapper.map(sesionCreateUpdateDTO, Nutricion.class);
        }else{
            throw new IllegalArgumentException("Tipo de sesion no soportado");
        }
    }

}
