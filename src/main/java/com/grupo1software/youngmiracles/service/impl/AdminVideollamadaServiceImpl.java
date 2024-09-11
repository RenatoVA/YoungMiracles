package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.model.entity.Videollamada;
import com.grupo1software.youngmiracles.repository.VideollamadaRepository;
import com.grupo1software.youngmiracles.service.AdminVideollamadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service

public class AdminVideollamadaServiceImpl implements AdminVideollamadaService {
    private final VideollamadaRepository videollamadaRepository;

    @Transactional
    @Override
    public Videollamada createVideollamada(Videollamada videollamada) {
        return videollamadaRepository.save(videollamada);
    }

    @Transactional(readOnly = true)
    @Override
    public Videollamada getVideollamadaById(Long id) {
        return videollamadaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Videollamada> getAllVideollamadas() {
        return videollamadaRepository.findAll();
    }

    @Transactional
    @Override
    public Videollamada updateVideollamada(Long id, Videollamada videollamada) {
        Videollamada v=videollamadaRepository.findById(id).orElse(null);
        if (v!=null) {
            v.setDuracion(videollamada.getDuracion());
            v.setAsunto(videollamada.getAsunto());
            v.setFecha(videollamada.getFecha());
            v.setAdultoMayor(videollamada.getAdultoMayor());
            v.setVoluntario(videollamada.getVoluntario());
            return videollamadaRepository.save(v);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteVideollamada(Long id) {
        videollamadaRepository.deleteById(id);

    }

    @Transactional(readOnly = true)
    @Override
    public List<Videollamada> getVideollamadasByAdultoMayor(Long adultoMayorId) {
        return videollamadaRepository.findByAdultoMayorId(adultoMayorId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Videollamada> getVideollamadasByVoluntario(Long voluntarioId) {
        return videollamadaRepository.findByVoluntarioId(voluntarioId);
    }
}
