package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.UsuarioDTO;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.mapper.UsuarioMapper;
import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Familiar;
import com.grupo1software.youngmiracles.model.entity.Usuario;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import com.grupo1software.youngmiracles.repository.UsuarioRepository;
import com.grupo1software.youngmiracles.service.AdminUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUsuarioServiceImpl implements AdminUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    @Transactional
    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setFechaRegistro(LocalDateTime.now());
        Usuario usuarioCreado= usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioCreado);
    }

    @Transactional (readOnly = true)
    @Override
    public UsuarioDTO getUsuarioById(Long id) {
        return usuarioMapper.toDTO(usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrada con el ID: " + id)));
    }

    @Transactional (readOnly = true)
    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll().stream().map(usuarioMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioactualizadoDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + id));

        Usuario usuarioActualizado = usuarioMapper.toEntity(usuarioactualizadoDTO);
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setApellido_paterno(usuarioActualizado.getApellido_paterno());
        usuarioExistente.setApellido_materno(usuarioActualizado.getApellido_materno());
        usuarioExistente.setEdad(usuarioActualizado.getEdad());
        usuarioExistente.setGenero(usuarioActualizado.getGenero());
        usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        switch (usuarioExistente) {
            case AdultoMayor adultoMayor when usuarioActualizado instanceof AdultoMayor ->
                    updateAdultoMayor(adultoMayor, (AdultoMayor) usuarioActualizado);
            case Voluntario voluntario when usuarioActualizado instanceof Voluntario ->
                    updateVoluntario(voluntario, (Voluntario) usuarioActualizado);
            case Familiar familiar when usuarioActualizado instanceof Familiar ->
                    updateFamiliar(familiar, (Familiar) usuarioActualizado);
            default -> throw new IllegalArgumentException("Tipo de usuario no soportado");
        }
        return usuarioMapper.toDTO(usuarioRepository.save(usuarioExistente));
    }

    @Transactional
    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    private void updateAdultoMayor(AdultoMayor adultoMayor, AdultoMayor details) {
        adultoMayor.setCondicionSalud(details.getCondicionSalud());
        adultoMayor.setNivelActividad(details.getNivelActividad());
        adultoMayor.setNecesitaAsistenciaFamiliar(details.getNecesitaAsistenciaFamiliar());
    }

    private void updateVoluntario(Voluntario voluntario, Voluntario details) {
        voluntario.setEspecialidad(details.getEspecialidad());
        voluntario.setHorasDisponibles(details.getHorasDisponibles());
        voluntario.setExperiencia(details.getExperiencia());
    }

    private void updateFamiliar(Familiar familiar, Familiar details) {
        familiar.setRelacionConAdulto(details.getRelacionConAdulto());
        familiar.setUsuarioAsociado(details.getUsuarioAsociado());
    }

}
