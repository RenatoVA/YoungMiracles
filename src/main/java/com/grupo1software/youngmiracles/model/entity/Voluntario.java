package com.grupo1software.youngmiracles.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "voluntarios")
public class Voluntario extends Usuario {
    private String especialidad;
    private Integer horasDisponibles;
    private Integer experiencia;

    @ManyToMany
    @JoinTable(
            name = "voluntario_capacitacion",
            joinColumns = @JoinColumn(name = "voluntario_id"),
            inverseJoinColumns = @JoinColumn(name = "capacitacion_id"))
    private List<Capacitaciones> capacitaciones = new ArrayList<>();
}