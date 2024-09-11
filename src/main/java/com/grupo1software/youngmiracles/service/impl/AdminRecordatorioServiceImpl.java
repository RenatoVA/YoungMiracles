package com.grupo1software.youngmiracles.service.impl;


import com.grupo1software.youngmiracles.model.entity.*;
import com.grupo1software.youngmiracles.repository.RecordatorioRepository;
import com.grupo1software.youngmiracles.service.AdminRecordatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminRecordatorioServiceImpl implements AdminRecordatorioService {

    private final RecordatorioRepository recordatorioRepository;

    @Transactional
    @Override
    public Recordatorio createRecordatorio(Recordatorio recordatorio) {
        if (recordatorio instanceof RecordatorioSesion) {
            return createRecordatorioSesion((RecordatorioSesion) recordatorio);
        } else if (recordatorio instanceof RecordatorioPastilla) {
            return createRecordatorioPastilla((RecordatorioPastilla) recordatorio);
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Recordatorio getRecordatorioById(Long id) {
        return recordatorioRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recordatorio> getAllRecordatorios() {
        return recordatorioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recordatorio> getRecordatoriosByUsuarioId(Long usuarioId) {
        return recordatorioRepository.findByUsuarioId(usuarioId);
    }

    @Transactional
    @Override
    public Recordatorio updateRecordatorio(Long id, Recordatorio recordatorioactualizado) {
        Recordatorio recordatorio = recordatorioRepository.findById(id).orElse(null);
        if (recordatorio != null) {
            recordatorio.setUsuario(recordatorioactualizado.getUsuario());
            recordatorio.setDescripcion(recordatorioactualizado.getDescripcion());
            switch (recordatorio) {
                case RecordatorioSesion recordatorioSesion when recordatorioactualizado instanceof RecordatorioSesion ->
                        updateRecordatorioSesion(recordatorioSesion, (RecordatorioSesion) recordatorioactualizado);
                case RecordatorioPastilla taller when recordatorioactualizado instanceof RecordatorioPastilla ->
                        updateRecordatorioPastilla(taller, (RecordatorioPastilla) recordatorioactualizado);
                default -> {
                }
            }
            return recordatorioRepository.save(recordatorio);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteRecordatorio(Long id) {
        recordatorioRepository.deleteById(id);
    }


    private Recordatorio createRecordatorioPastilla(Recordatorio recordatorio) {
        if (recordatorio instanceof RecordatorioPastilla) {
            return recordatorioRepository.save(recordatorio);
        }
        throw new IllegalArgumentException("El recordatorio debe ser de tipo pastilla");
    }

    private Recordatorio createRecordatorioSesion(Recordatorio recordatorio) {
        if (recordatorio instanceof RecordatorioSesion) {
            return recordatorioRepository.save(recordatorio);
        }
        throw new IllegalArgumentException("El recordatorio debe ser de tipo sesion");
    }

    private void updateRecordatorioPastilla(RecordatorioPastilla recordatorio, RecordatorioPastilla details) {
        recordatorio.setNombrePastilla(details.getNombrePastilla());
        recordatorio.setDosis(details.getDosis());
        recordatorio.setFecha(details.getFecha());
    }

    private void updateRecordatorioSesion(RecordatorioSesion recordatorio, RecordatorioSesion details) {
        recordatorio.setSesion(details.getSesion());
    }
}
