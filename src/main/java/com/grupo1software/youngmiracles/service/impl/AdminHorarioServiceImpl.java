package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.model.entity.Horario;
import com.grupo1software.youngmiracles.repository.HorarioRepository;
import com.grupo1software.youngmiracles.service.AdminHorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminHorarioServiceImpl implements AdminHorarioService {
    private final HorarioRepository horarioRepository;

    @Transactional
    @Override
    public Horario createHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Transactional(readOnly = true)
    @Override
    public Horario getHorarioById(Long id) {
        return horarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Horario no encontrada con el ID: " + id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Horario> getHorariosByVoluntario(Long voluntarioId) {

        return horarioRepository.findByVoluntarioId(voluntarioId);
    }

    @Transactional
    @Override
    public Horario updateHorario(Long id, Horario horario) {
        Horario h = horarioRepository.findById(id).orElse(null);
        if (h != null) {
            h.setHorario(horario.getHorario());
            h.setVoluntario(horario.getVoluntario());
            h.setDia(horario.getDia());
            return horarioRepository.save(h);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }
}
