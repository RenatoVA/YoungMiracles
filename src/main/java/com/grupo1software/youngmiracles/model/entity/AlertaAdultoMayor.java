package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alerta_adulto_mayor")
public class AlertaAdultoMayor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id")
    private AdultoMayor adultoMayor;

    private String mensajeAlerta;

    private LocalDateTime fechaAlerta;

}
