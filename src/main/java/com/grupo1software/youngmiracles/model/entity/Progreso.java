package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="progresos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="sesion_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_PROGRESO_SESION"))
    private Sesion sesion ;

    private LocalDateTime fecha;
    private String estado;


}
