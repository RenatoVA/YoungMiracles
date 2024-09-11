package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Familiar;
import com.grupo1software.youngmiracles.model.entity.Usuario;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import com.grupo1software.youngmiracles.repository.UsuarioRepository;
import com.grupo1software.youngmiracles.service.AdminUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUsuarioServiceImpl implements AdminUsuarioService {
    private final UsuarioRepository usuarioRepository;


    @Transactional
    @Override
    public Usuario createUsuario(Usuario usuario) {
        if (usuario instanceof AdultoMayor) {
            return createAdultoMayor((AdultoMayor) usuario);
        } else if (usuario instanceof Voluntario) {
            return createVoluntario((Voluntario) usuario);
        } else if (usuario instanceof Familiar) {
            return createFamiliar((Familiar) usuario);
        } else {
            return null;
        }
    }

    @Transactional (readOnly = true)
    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Transactional (readOnly = true)
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public Usuario updateUsuario(Long id, Usuario usuarioactualizado) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNombre(usuarioactualizado.getNombre());
            usuario.setApellido_paterno(usuarioactualizado.getApellido_paterno());
            usuario.setApellido_materno(usuarioactualizado.getApellido_materno());
            usuario.setEdad(usuarioactualizado.getEdad());
            usuario.setGenero(usuarioactualizado.getGenero());
            usuario.setCorreo(usuarioactualizado.getCorreo());
            switch (usuario) {
                case AdultoMayor adultoMayor when usuarioactualizado instanceof AdultoMayor ->
                        updateAdultoMayor(adultoMayor, (AdultoMayor) usuarioactualizado);
                case Voluntario voluntario when usuarioactualizado instanceof Voluntario ->
                        updateVoluntario(voluntario, (Voluntario) usuarioactualizado);
                case Familiar familiar when usuarioactualizado instanceof Familiar ->
                        updateFamiliar(familiar, (Familiar) usuarioactualizado);
                default -> {
                }
            }
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario createAdultoMayor(Usuario usuario) {
        if (usuario instanceof AdultoMayor) {
            usuario.setFechaRegistro(LocalDateTime.now());
            return usuarioRepository.save(usuario);
        }
        throw new IllegalArgumentException("El usuario debe ser un AdultoMayor");
    }

    public Usuario createVoluntario(Usuario usuario) {
        if (usuario instanceof Voluntario) {
            usuario.setFechaRegistro(LocalDateTime.now());
            return usuarioRepository.save(usuario);
        }
        throw new IllegalArgumentException("El usuario debe ser un Voluntario");
    }

    public Usuario createFamiliar(Usuario usuario) {
        if (usuario instanceof Familiar) {
            usuario.setFechaRegistro(LocalDateTime.now());
            return usuarioRepository.save(usuario);
        }
        throw new IllegalArgumentException("El usuario debe ser un Familiar");
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
