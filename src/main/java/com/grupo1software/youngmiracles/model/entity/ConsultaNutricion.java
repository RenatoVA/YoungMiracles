package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;

@Entity
@Data
@Builder
@Table(name = "consulta_nutricion")
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

    public ConsultaNutricion(Long id, LocalDate fechaConsulta, String condicionSalud, String recomendaciones, AdultoMayor adultoMayor) {
        this.id = id;
        this.fechaConsulta = fechaConsulta;
        this.condicionSalud = condicionSalud;
        this.recomendaciones = recomendaciones;
        this.adultoMayor = adultoMayor;
    }

    public ConsultaNutricion() {
    }
}

