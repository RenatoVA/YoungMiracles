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
}
