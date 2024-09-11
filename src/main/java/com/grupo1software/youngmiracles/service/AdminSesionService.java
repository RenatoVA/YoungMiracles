package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Sesion;

import java.util.List;

public interface AdminSesionService {
    Sesion createSesion(Sesion session);
    Sesion getSesionById(Long id);
    List<Sesion> getAllSesions();
    Sesion updateSesion(Long id, Sesion session);
    void deleteSesion(Long id);
    List<Sesion> getSesionsByAdultoMayor(Long adultoMayorId);
    List<Sesion> getSesionsByVoluntario(Long voluntarioId);
}
