package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.*;

import java.util.List;

public interface AdminUsuarioService {
    UsuarioDTO createUsuarioCustomer(UsuarioDTO usuarioDTO);
    UsuarioDTO createUsuarioAdmin(UsuarioDTO usuarioDTO);
    UsuarioDTO getUsuarioById(Long id);
    List<UsuarioDTO> getAllUsuarios();
    UpdateUsuarioResponseDTO updateUsuario(Long id, UsuarioUpdateDTO usuarioactualizadoDTO);
    UsuarioDTO login(LoginDTO loginDTO);
    List<UsuarioDTO> getAllVoluntarios();
    void deleteUsuario(Long id);
}
