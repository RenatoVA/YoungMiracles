package com.grupo1software.youngmiracles.mapper;


import com.grupo1software.youngmiracles.dto.*;
import com.grupo1software.youngmiracles.model.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SesionMapper {

    private final ModelMapper modelMapper;
    private final HorarioMapper horarioMapper;

    public SesionMapper(ModelMapper modelMapper, HorarioMapper horarioMapper) {
        this.modelMapper = modelMapper;
        this.horarioMapper = horarioMapper;
    }
    public SesionResponseDTO toDTO(Sesion sesion) {
        if(sesion instanceof Fisioterapia){
            FisioterapiaResponseDTO  fisioterapiaDTO = new FisioterapiaResponseDTO();
            fisioterapiaDTO.setId(sesion.getId());
            fisioterapiaDTO.setTipoFisioterapia(((Fisioterapia) sesion).getTipoFisioterapia());
            fisioterapiaDTO.setObservaciones(((Fisioterapia) sesion).getObservaciones());
            fisioterapiaDTO.setFecha(sesion.getFecha());
            fisioterapiaDTO.setHorario(horarioMapper.toDTO(sesion.getHorario()));
            fisioterapiaDTO.setDuracion(sesion.getDuracion());
            fisioterapiaDTO.setEstado(sesion.getEstado());
            fisioterapiaDTO.setAdultomayorId(sesion.getAdultoMayor().getId());
            fisioterapiaDTO.setVoluntarioId(sesion.getVoluntario().getId());
            fisioterapiaDTO.setAdultomayorNombre(sesion.getAdultoMayor().getNombre()+' '+sesion.getAdultoMayor().getApellido_paterno()+' '+sesion.getAdultoMayor().getApellido_materno());
            fisioterapiaDTO.setVoluntarioNombre(sesion.getVoluntario().getNombre()+' '+sesion.getVoluntario().getApellido_paterno()+' '+sesion.getVoluntario().getApellido_materno());
            return fisioterapiaDTO;
        }else if (sesion instanceof Taller){
            TallerResponseDTO tallerResponseDTO= new TallerResponseDTO();
            tallerResponseDTO.setId(sesion.getId());
            tallerResponseDTO.setDuracion(sesion.getDuracion());
            tallerResponseDTO.setEstado(sesion.getEstado());
            tallerResponseDTO.setFecha(sesion.getFecha());
            tallerResponseDTO.setHorario(horarioMapper.toDTO(sesion.getHorario()));
            tallerResponseDTO.setAdultomayorId(sesion.getAdultoMayor().getId());
            tallerResponseDTO.setVoluntarioId(sesion.getVoluntario().getId());
            tallerResponseDTO.setCapacidadMaxima(((Taller) sesion).getCapacidadMaxima());
            tallerResponseDTO.setDescripcion(((Taller) sesion).getDescripcion());
            tallerResponseDTO.setMaterialRequerido(((Taller) sesion).getMaterialRequerido());
            tallerResponseDTO.setAdultomayorNombre(sesion.getAdultoMayor().getNombre()+' '+sesion.getAdultoMayor().getApellido_paterno()+' '+sesion.getAdultoMayor().getApellido_materno());
            tallerResponseDTO.setVoluntarioNombre(sesion.getVoluntario().getNombre()+' '+sesion.getVoluntario().getApellido_paterno()+' '+sesion.getVoluntario().getApellido_materno());
            return tallerResponseDTO;
        }
        else if (sesion instanceof Nutricion){
            NutricionResponseDTO nutricionResponseDTO= new NutricionResponseDTO();
            nutricionResponseDTO.setId(sesion.getId());
            nutricionResponseDTO.setDuracion(sesion.getDuracion());
            nutricionResponseDTO.setEstado(sesion.getEstado());
            nutricionResponseDTO.setFecha(sesion.getFecha());
            nutricionResponseDTO.setHorario(horarioMapper.toDTO(sesion.getHorario()));
            nutricionResponseDTO.setAdultomayorId(sesion.getAdultoMayor().getId());
            nutricionResponseDTO.setVoluntarioId(sesion.getVoluntario().getId());
            nutricionResponseDTO.setIndicaciones(((Nutricion) sesion).getIndicaciones());
            nutricionResponseDTO.setReceta(((Nutricion) sesion).getReceta());
            nutricionResponseDTO.setAdultomayorNombre(sesion.getAdultoMayor().getNombre()+' '+sesion.getAdultoMayor().getApellido_paterno()+' '+sesion.getAdultoMayor().getApellido_materno());
            nutricionResponseDTO.setVoluntarioNombre(sesion.getVoluntario().getNombre()+' '+sesion.getVoluntario().getApellido_paterno()+' '+sesion.getVoluntario().getApellido_materno());
            return nutricionResponseDTO;
        }else {
            throw new IllegalArgumentException("Tipo de sesion no soportado");
        }
    }
    public Sesion toEntity(SesionCreateUpdateDTO sesionCreateUpdateDTO) {
        if(sesionCreateUpdateDTO instanceof FisioterapiaDTO){
            Fisioterapia fisioterapia= new Fisioterapia();
            fisioterapia.setEstado(sesionCreateUpdateDTO.getEstado());
            fisioterapia.setDuracion(sesionCreateUpdateDTO.getDuracion());
            fisioterapia.setTipoFisioterapia(((FisioterapiaDTO) sesionCreateUpdateDTO).getTipoFisioterapia());
            fisioterapia.setObservaciones(((FisioterapiaDTO) sesionCreateUpdateDTO).getObservaciones());

            return fisioterapia;
        }else if (sesionCreateUpdateDTO instanceof TallerDTO){
            Taller taller= new Taller();
            taller.setEstado(sesionCreateUpdateDTO.getEstado());
            taller.setDuracion(sesionCreateUpdateDTO.getDuracion());
            taller.setDescripcion(((TallerDTO) sesionCreateUpdateDTO).getDescripcion());
            taller.setCapacidadMaxima(((TallerDTO) sesionCreateUpdateDTO).getCapacidadMaxima());
            taller.setMaterialRequerido(((TallerDTO) sesionCreateUpdateDTO).getMaterialRequerido());
            return taller;
        }else if (sesionCreateUpdateDTO instanceof NutricionDTO){
            Nutricion nutricion= new Nutricion();
            nutricion.setEstado(sesionCreateUpdateDTO.getEstado());
            nutricion.setDuracion(sesionCreateUpdateDTO.getDuracion());
            nutricion.setIndicaciones(((NutricionDTO) sesionCreateUpdateDTO).getIndicaciones());
            nutricion.setReceta(((NutricionDTO) sesionCreateUpdateDTO).getReceta());
            return nutricion;
        }else{
            throw new IllegalArgumentException("Tipo de sesion no soportado");
        }
    }

}
