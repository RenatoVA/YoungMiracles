package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.RetroalimentacionDTO;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.mapper.RetroalimentacionMapper;
import com.grupo1software.youngmiracles.model.entity.Retroalimentacion;
import com.grupo1software.youngmiracles.repository.RetroalimentacionRepository;
import com.grupo1software.youngmiracles.service.AdminRetroalimentacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminRetroalimentacionServiceImpl implements AdminRetroalimentacionService {
    private final RetroalimentacionRepository retroalimentacionRepository;
    private final RetroalimentacionMapper retroalimentacionMapper;

    @Override
    public RetroalimentacionDTO createRetroalimentacion(RetroalimentacionDTO retroalimentacionDTO) {
        Retroalimentacion retroalimentacion=retroalimentacionMapper.toEntity(retroalimentacionDTO);
        retroalimentacionRepository.save(retroalimentacion);
        return retroalimentacionMapper.toDTO(retroalimentacion);
    }

    @Override
    public RetroalimentacionDTO getRetroalimentacionById(Long Id) {
        return retroalimentacionMapper.toDTO(retroalimentacionRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Retroalimentacion no encontrada con el ID: " + Id)));
    }

    @Override
    public RetroalimentacionDTO updateRetroalimentacion(Long Id, RetroalimentacionDTO retroalimentacionDTO) {
        Retroalimentacion retroalimentacionexistente=retroalimentacionRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Retroalimentacion no encontrada con el ID: " + Id));
        Retroalimentacion retroalimentacionActualizado=retroalimentacionMapper.toEntity(retroalimentacionDTO);
        retroalimentacionexistente.setComentario(retroalimentacionActualizado.getComentario());
        retroalimentacionexistente.setPuntaje(retroalimentacionActualizado.getPuntaje());
        return retroalimentacionMapper.toDTO(retroalimentacionRepository.save(retroalimentacionexistente));
    }

    @Override
    public List<RetroalimentacionDTO> getRetroalimentacionesByVoluntario(Long voluntarioId) {

        return retroalimentacionRepository.findByVoluntarioId(voluntarioId).stream().map(retroalimentacionMapper::toDTO).toList();
    }

    @Override
    public void deleteRetroalimentacion(Long Id) {
        retroalimentacionRepository.deleteById(Id);
    }
}
