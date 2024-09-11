package com.grupo1software.youngmiracles.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "voluntarios")
public class Voluntario extends Usuario {
    private String especialidad;
    private Integer horasDisponibles;
    private Integer experiencia;
}