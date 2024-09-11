package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Progreso;

import java.util.List;

public interface AdminProgresoService {
    Progreso createProgreso(Progreso progreso);
    Progreso getProgresoById(Long id);
    List<Progreso> getAllProgresos();
    List<Progreso> getProgresosBySesion(Long sesionId);
    Progreso updateProgreso(Long id, Progreso progreso);
    void deleteProgreso(Long id);
}
