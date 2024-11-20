package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.AuthResponseDTO;
import com.grupo1software.youngmiracles.dto.LoginDTO;
import com.grupo1software.youngmiracles.dto.UsuarioDTO;
import com.grupo1software.youngmiracles.exception.BadRequestException;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.exception.RoleNotFoundException;
import com.grupo1software.youngmiracles.mapper.UsuarioMapper;
import com.grupo1software.youngmiracles.model.entity.*;
import com.grupo1software.youngmiracles.model.enums.ERole;
import com.grupo1software.youngmiracles.repository.RoleRepository;
import com.grupo1software.youngmiracles.repository.UsuarioRepository;
import com.grupo1software.youngmiracles.security.UserPrincipal;
import com.grupo1software.youngmiracles.service.AdminUsuarioService;
import lombok.RequiredArgsConstructor;
import com.grupo1software.youngmiracles.security.TokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminUsuarioServiceImpl implements AdminUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private UsuarioDTO registerUserWithRole(UsuarioDTO registrationDTO, ERole roleEnum) {
        System.out.println(roleEnum);
        boolean existsByEmail = usuarioRepository.existsByCorreo(registrationDTO.getCorreo());
        if(existsByEmail){
            throw new BadRequestException("El correo ya esta registrado");
        }
        List<Role> roles=roleRepository.findAll();
        roles.forEach(System.out::println);
        Role role = roleRepository.findByNombre(roleEnum)
                .orElseThrow(() -> new RoleNotFoundException("Error: Role is not found."));

        String rawpassword=registrationDTO.getPassword();
        registrationDTO.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        Usuario usuario = usuarioMapper.toEntity(registrationDTO);
        usuario.setRole(role);
        usuario.setFechaRegistro(LocalDateTime.now());
        Usuario saveduser =usuarioRepository.save(usuario);
        System.out.println(saveduser);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registrationDTO.getCorreo(), rawpassword)
        );
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        Usuario usuarionuevo = userPrincipal.getUsuario();
        System.out.println(usuarionuevo);

        boolean isAdmin = usuarionuevo.getRole().getNombre().equals(ERole.ADMIN);

        //String token = "abc123";
        // Generar el token JWT usando el TokenProvider
        String token = tokenProvider.createAccessToken(authentication);
        UsuarioDTO usuarioDTO=usuarioMapper.toDTO(usuarionuevo);
        usuarioDTO.setToken(token);
        usuarioDTO.setRole(usuarionuevo.getRole().getNombre().toString());
        return usuarioDTO;
    }


    @Transactional
    @Override
    public UsuarioDTO createUsuarioCustomer(UsuarioDTO usuarioDTO) {
        return registerUserWithRole(usuarioDTO, ERole.CUSTOMER);
    }
    @Transactional
    @Override
    public UsuarioDTO createUsuarioAdmin(UsuarioDTO usuarioDTO) {
        return registerUserWithRole(usuarioDTO, ERole.ADMIN);
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
    @Transactional (readOnly = true)
    @Override
    public List<UsuarioDTO> getAllVoluntarios() {
        List<Usuario> voluntarios = new ArrayList<>();
        for (Usuario usuario : usuarioRepository.findAll()) {
            if (usuario instanceof Voluntario) {
                voluntarios.add(usuario);
            }
        }
        return voluntarios.stream().map(usuarioMapper::toDTO).toList();
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

    @Override
    public UsuarioDTO login(LoginDTO loginDTO) {
        // Autenticar al usuario utilizando AuthenticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getCorreo(), loginDTO.getContrasena())
        );

        // Una vez autenticado, el objeto autentication contiene la informacion del usuario autenticado
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        Usuario usuario = userPrincipal.getUsuario();

        // Verificar si es un administrador
        boolean isAdmin = usuario.getRole().getNombre().equals(ERole.ADMIN);

        //String token = "abc123";
        // Generar el token JWT usando el TokenProvider
        String token = tokenProvider.createAccessToken(authentication);
        UsuarioDTO usuarioDTO=usuarioMapper.toDTO(usuario);
        usuarioDTO.setToken(token);
        usuarioDTO.setRole(usuario.getRole().getNombre().toString());
        return usuarioDTO;
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
