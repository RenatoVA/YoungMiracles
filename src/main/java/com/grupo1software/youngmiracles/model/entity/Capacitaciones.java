package com.grupo1software.youngmiracles.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "capacitaciones")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Capacitaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCapacitacion;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany(mappedBy = "capacitaciones")
    private List<Voluntario> voluntarios = new ArrayList<>();
}
