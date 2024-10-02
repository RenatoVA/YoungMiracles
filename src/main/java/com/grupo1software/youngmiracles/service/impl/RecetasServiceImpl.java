package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.model.entity.Recetas;
import com.grupo1software.youngmiracles.repository.RecetasRepository;
import com.grupo1software.youngmiracles.service.RecetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RecetasServiceImpl implements RecetasService {
    private final RecetasRepository recetasRepository;


    @Transactional
    @Override
    public Recetas crearReceta(Recetas receta) {
        return recetasRepository.save(receta);
    }

    @Transactional(readOnly = true)
    @Override
    public Recetas getRecetaById(Long id) {
        return recetasRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recetas> getAllRecetas() {
        return recetasRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Recetas> findByNombreReceta(String nombreReceta) {
        return recetasRepository.findByNombreReceta(nombreReceta);
    }
}
