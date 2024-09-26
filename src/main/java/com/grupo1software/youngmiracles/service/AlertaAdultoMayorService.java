package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.AlertaAdultoMayor;

import java.util.List;

public interface AlertaAdultoMayorService {
    AlertaAdultoMayor crearAlerta(AlertaAdultoMayor alertaAdultoMayor);
    AlertaAdultoMayor getAlertaById(Long id);
    List<AlertaAdultoMayor> getAllAlertas();
    List<AlertaAdultoMayor> listarAlertasPorAdultoMayor(Long adultoMayorId);
    void deleteAlerta(Long id);

}
