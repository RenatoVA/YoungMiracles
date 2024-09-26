package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name= "nutriciones")
public class Nutricion extends Sesion{
    private String indicaciones;
    private String receta;
}
