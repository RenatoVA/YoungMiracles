package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.CreateUpdateHorarioDTO;
import com.grupo1software.youngmiracles.dto.HorarioResponseDTO;
import com.grupo1software.youngmiracles.model.entity.Horario;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class HorarioMapper {

    private final ModelMapper modelMapper;
    public HorarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public HorarioResponseDTO toDTO(Horario horario) {
        HorarioResponseDTO horarioResponseDTO = new HorarioResponseDTO();
        horarioResponseDTO.setFecha(horario.getFecha());
        horarioResponseDTO.setId(horario.getId());
        horarioResponseDTO.setHora_inicio(horario.getHora_inicio());
        horarioResponseDTO.setHora_fin(horario.getHora_fin());
        horarioResponseDTO.setVoluntario_id(horario.getVoluntario().getId());
        horarioResponseDTO.setVoluntario_nombre(horario.getVoluntario().getNombre()+' '+horario.getVoluntario().getApellido_paterno()+' '+horario.getVoluntario().getApellido_materno());
        horarioResponseDTO.setVoluntario_especialidad(horario.getVoluntario().getEspecialidad());
        return horarioResponseDTO;
    }
    public Horario toEntity(CreateUpdateHorarioDTO createUpdateHorarioDTO, Voluntario voluntario) {
        Horario horario = new Horario();
        horario.setFecha(createUpdateHorarioDTO.getFecha());
        horario.setHora_inicio(createUpdateHorarioDTO.getHora_inicio());
        horario.setHora_fin(createUpdateHorarioDTO.getHora_fin());
        horario.setVoluntario(voluntario);
        return horario;
    }
}
