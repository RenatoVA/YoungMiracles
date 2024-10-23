package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.CapacitacionDTO;
import com.grupo1software.youngmiracles.model.entity.Capacitacion;
import org.springframework.stereotype.Component;

@Component
public class CapacitacionMapper {

    // Convertir de entidad a DTO
    public CapacitacionDTO toDTO(Capacitacion capacitacion) {
        if (capacitacion == null) {
            return null;
        }

        CapacitacionDTO capacitacionDTO = new CapacitacionDTO();
        capacitacionDTO.setId(capacitacion.getId());
        capacitacionDTO.setTitulo(capacitacion.getTitulo());
        capacitacionDTO.setDescripcion(capacitacion.getDescripcion());
        capacitacionDTO.setContenido(capacitacion.getContenido());
        
        // Mapea el id del voluntario si existe
        if (capacitacion.getVoluntario() != null) {
            capacitacionDTO.setVoluntarioId(capacitacion.getVoluntario().getId());
        }

        return capacitacionDTO;
    }

    // Convertir de DTO a entidad
    public Capacitacion toEntity(CapacitacionDTO capacitacionDTO) {
        if (capacitacionDTO == null) {
            return null;
        }

        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setId(capacitacionDTO.getId());
        capacitacion.setTitulo(capacitacionDTO.getTitulo());
        capacitacion.setDescripcion(capacitacionDTO.getDescripcion());
        capacitacion.setContenido(capacitacionDTO.getContenido());

        // Aquí puedes establecer la relación con Voluntario si tienes el objeto Voluntario disponible
        // capacitacion.setVoluntario(voluntario);

        return capacitacion;
    }
}
