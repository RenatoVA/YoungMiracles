package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "consultanutricion")
@Data
@Builder
public class ConsultaNutricion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaConsulta;
    private String condicionSalud;
    private String recomendaciones;

    @ManyToOne
    @JoinColumn(name = "adulto_mayor")
    private AdultoMayor adultoMayor;
}
