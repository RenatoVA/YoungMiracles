package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.MensajeDTO;

public interface AdminMensajeService {
    MensajeDTO createMensaje(MensajeDTO mensaje);
    MensajeDTO getMensajeByID(Long Id);
    MensajeDTO updateMensaje(Long Id, MensajeDTO mensajeactualizadoDTO);
    void deleteMensaje(Long Id);
}
