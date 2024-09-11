package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Usuario;

import java.util.List;

public interface AdminUsuarioService {
    Usuario createUsuario(Usuario usuario);
    Usuario getUsuarioById(Long id);
    List<Usuario> getAllUsuarios();
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
}
