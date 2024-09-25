package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.UsuarioDTO;

import java.util.List;

public interface AdminUsuarioService {
    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO getUsuarioById(Long id);
    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioactualizadoDTO);
    void deleteUsuario(Long id);
}
