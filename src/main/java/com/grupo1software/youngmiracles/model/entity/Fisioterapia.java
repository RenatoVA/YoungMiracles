package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name= "fisioterapias")
public class Fisioterapia extends Sesion {
    private String tipoFisioterapia;
    private String observaciones;
}
