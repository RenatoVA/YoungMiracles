package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Builder
@Table(name = "recetas")
@AllArgsConstructor
public class Recetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreReceta;

    @Column(nullable = false)
    private String ingredientes;

    @Column(nullable = false)
    private String instrucciones;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    public Recetas() {

    }
}
