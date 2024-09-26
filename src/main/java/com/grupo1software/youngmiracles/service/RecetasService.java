package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.model.entity.Recetas;

import java.util.List;

public interface RecetasService {
    Recetas crearReceta(Recetas receta);
    Recetas getRecetaById(Long id);
    List<Recetas> getAllRecetas();
    List<Recetas> findByNombreReceta(String nombreReceta);
}
