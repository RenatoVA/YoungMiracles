package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.RecetasDTO;
import com.grupo1software.youngmiracles.model.entity.Recetas;

import java.util.List;

public interface RecetasService {

    RecetasDTO crearReceta(RecetasDTO recetaDTO);

    RecetasDTO getRecetaById(Long id);

    List<RecetasDTO> getAllRecetas();

    List<RecetasDTO> findByNombreReceta(String nombreReceta);
}
