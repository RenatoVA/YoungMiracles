package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.RecetasDTO;
import com.grupo1software.youngmiracles.mapper.RecetasMapper;
import com.grupo1software.youngmiracles.model.entity.Recetas;
import com.grupo1software.youngmiracles.repository.RecetasRepository;
import com.grupo1software.youngmiracles.service.RecetasService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecetasServiceImpl implements RecetasService {

    private final RecetasRepository recetasRepository;
    private final RecetasMapper recetasMapper;

    @Transactional
    @Override
    public RecetasDTO crearReceta(RecetasDTO recetaDTO) {
        Recetas receta = recetasMapper.toEntity(recetaDTO);
        Recetas savedReceta = recetasRepository.save(receta);
        return recetasMapper.toDto(savedReceta);
    }

    @Transactional(readOnly = true)
    @Override
    public RecetasDTO getRecetaById(Long id) {
        Recetas receta = recetasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Receta not found"));
        return recetasMapper.toDto(receta);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RecetasDTO> getAllRecetas() {
        List<Recetas> recetas = recetasRepository.findAll();
        return recetas.stream()
                .map(recetasMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<RecetasDTO> findByNombreReceta(String nombreReceta) {
        List<Recetas> recetas = recetasRepository.findByNombreReceta(nombreReceta);
        return recetas.stream()
                .map(recetasMapper::toDto)
                .collect(Collectors.toList());
    }
}
