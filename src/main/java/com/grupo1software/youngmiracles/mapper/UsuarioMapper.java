package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.AdultoMayorDTO;
import com.grupo1software.youngmiracles.dto.FamiliarDTO;
import com.grupo1software.youngmiracles.dto.UsuarioDTO;
import com.grupo1software.youngmiracles.dto.VoluntarioDTO;
import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Familiar;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.grupo1software.youngmiracles.model.entity.Usuario;

@Component
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.typeMap(Voluntario.class, VoluntarioDTO.class);
        this.modelMapper.typeMap(VoluntarioDTO.class, Voluntario.class);

        this.modelMapper.typeMap(AdultoMayor.class, AdultoMayorDTO.class);
        this.modelMapper.typeMap(AdultoMayorDTO.class, AdultoMayor.class);

        this.modelMapper.typeMap(Familiar.class,FamiliarDTO.class);
        this.modelMapper.typeMap(FamiliarDTO.class, Familiar.class);
    }
    public UsuarioDTO toDTO(Usuario usuario) {

        if (usuario instanceof Voluntario) {
            return modelMapper.map(usuario, VoluntarioDTO.class);
        } else if (usuario instanceof AdultoMayor) {
            return modelMapper.map(usuario, AdultoMayorDTO.class);
        } else if (usuario instanceof Familiar){
            return modelMapper.map(usuario, FamiliarDTO.class);
        }else {
            throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if (usuarioDTO instanceof VoluntarioDTO) {
            return modelMapper.map(usuarioDTO, Voluntario.class);
        } else if (usuarioDTO instanceof AdultoMayorDTO) {
            return modelMapper.map(usuarioDTO, AdultoMayor.class);
        } else if (usuarioDTO instanceof FamiliarDTO) {
            return modelMapper.map(usuarioDTO, Familiar.class);
        }else{
            throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
    }

}
