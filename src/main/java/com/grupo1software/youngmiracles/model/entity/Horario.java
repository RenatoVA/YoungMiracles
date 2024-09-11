package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="horarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dia;
    private String horario;

    @ManyToOne
    @JoinColumn(name="voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_HORARIO_VOLUNTARIO"))
    private Voluntario voluntario;
}
