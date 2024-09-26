package com.grupo1software.youngmiracles.service.impl;
import com.grupo1software.youngmiracles.service.AlertaAdultoMayorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.grupo1software.youngmiracles.model.entity.AlertaAdultoMayor;
import com.grupo1software.youngmiracles.repository.AlertaAdultoMayorRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlertaAdultoMayorServiceImpl implements AlertaAdultoMayorService {

   private final AlertaAdultoMayorRepository alertaAdultoMayorRepository;

    @Transactional
    @Override
    public AlertaAdultoMayor crearAlerta(AlertaAdultoMayor alertaAdultoMayor) {
        return alertaAdultoMayorRepository.save(alertaAdultoMayor);
    }

    @Transactional(readOnly = true)
    @Override
    public AlertaAdultoMayor getAlertaById(Long id) {
        return alertaAdultoMayorRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AlertaAdultoMayor> getAllAlertas() {
        return alertaAdultoMayorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<AlertaAdultoMayor> listarAlertasPorAdultoMayor(Long adultoMayorId) {
        return alertaAdultoMayorRepository.findByAdultoMayorId(adultoMayorId);
    }

    @Transactional
    @Override
    public void deleteAlerta(Long id) {
        alertaAdultoMayorRepository.deleteById(id);
    }
}
