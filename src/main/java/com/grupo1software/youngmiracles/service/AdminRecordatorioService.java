package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Recordatorio;

import java.util.List;

public interface AdminRecordatorioService {
    Recordatorio createRecordatorio(Recordatorio recordatorio);
    Recordatorio getRecordatorioById(Long id);
    List<Recordatorio> getAllRecordatorios();
    List<Recordatorio> getRecordatoriosByUsuarioId(Long usuarioId);
    Recordatorio updateRecordatorio(Long id, Recordatorio recordatorio);
    void deleteRecordatorio(Long id);
}
