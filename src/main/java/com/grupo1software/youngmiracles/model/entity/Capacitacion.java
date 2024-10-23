package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "capacitaciones")
public class Capacitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String contenido;

    // Relación con Voluntario
    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    private Voluntario voluntario;
}
