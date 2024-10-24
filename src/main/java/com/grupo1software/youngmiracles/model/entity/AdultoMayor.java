package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "adultos_mayores")
public class AdultoMayor extends Usuario {
    private String condicionSalud;
    private String nivelActividad;
    private Boolean necesitaAsistenciaFamiliar;

    // Constructor que acepta el id
    public AdultoMayor(Long id) {
        this.setId(id); // Asignamos el id al objeto adultoMayor
    }

    // Constructor por defecto (necesario para JPA)
    public AdultoMayor() {}
}
