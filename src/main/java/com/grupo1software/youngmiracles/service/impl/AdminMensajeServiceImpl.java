package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.MensajeDTO;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.mapper.MensajeMapper;
import com.grupo1software.youngmiracles.model.entity.Mensaje;
import com.grupo1software.youngmiracles.repository.MensajeRepository;
import com.grupo1software.youngmiracles.service.AdminMensajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AdminMensajeServiceImpl implements AdminMensajeService {

    private final MensajeRepository mensajeRepository;
    private final MensajeMapper mensajeMapper;
    @Transactional
    @Override
    public MensajeDTO createMensaje(MensajeDTO mensaje) {

        Mensaje nuevoMensaje = mensajeMapper.toEntity(mensaje);
        nuevoMensaje.setFechaEnvio(LocalDateTime.now());
        return mensajeMapper.toDTO(mensajeRepository.save(nuevoMensaje));

    }
    @Transactional(readOnly = true)
    @Override
    public MensajeDTO getMensajeByID(Long Id) {
        return mensajeMapper.toDTO(mensajeRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Mensaje no encontrada con el ID: " + Id)));
    }
    @Transactional
    @Override
    public MensajeDTO updateMensaje(Long Id, MensajeDTO mensajeactualizadoDTO) {
        Mensaje mensaje=mensajeRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + Id));
        Mensaje mensajeactualizado=mensajeMapper.toEntity(mensajeactualizadoDTO);
        mensaje.setTexto(mensajeactualizado.getTexto());

        return  mensajeMapper.toDTO(mensajeRepository.save(mensaje));
    }
    @Transactional
    @Override
    public void deleteMensaje(Long Id) {
        mensajeRepository.deleteById(Id);
    }
}
