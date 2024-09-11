package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "talleres")
public class Taller extends Sesion {
    private String descripcion;
    private Integer capacidadMaxima;
    private String materialRequerido;
}
