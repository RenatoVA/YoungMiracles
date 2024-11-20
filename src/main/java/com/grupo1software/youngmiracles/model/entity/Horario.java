package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
@Entity
@Table(name="horarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String hora_inicio;
    private String hora_fin;

    @ManyToOne
    @JoinColumn(name="voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_HORARIO_VOLUNTARIO"))
    private Voluntario voluntario;
}
