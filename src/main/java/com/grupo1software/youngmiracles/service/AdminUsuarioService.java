package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.AuthResponseDTO;
import com.grupo1software.youngmiracles.dto.LoginDTO;
import com.grupo1software.youngmiracles.dto.UsuarioDTO;

import java.util.List;

public interface AdminUsuarioService {
    UsuarioDTO createUsuarioCustomer(UsuarioDTO usuarioDTO);
    UsuarioDTO createUsuarioAdmin(UsuarioDTO usuarioDTO);
    UsuarioDTO getUsuarioById(Long id);
    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioactualizadoDTO);
    AuthResponseDTO login(LoginDTO loginDTO);
    void deleteUsuario(Long id);
}
