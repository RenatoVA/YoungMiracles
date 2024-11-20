package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "sesiones")
@Inheritance(strategy = InheritanceType.JOINED)

public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaRegistro;
    @ManyToOne()
    @JoinColumn(name = "horario_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_SESION_HORARIO"))
    private Horario horario;
    private LocalDate fecha;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_SESION_ADULTOMAYOR"))
    private AdultoMayor adultoMayor;
    @ManyToOne
    @JoinColumn(name = "voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_SESION_VOLUNTARIO"))
    private Voluntario voluntario;
    private Integer duracion;
}
