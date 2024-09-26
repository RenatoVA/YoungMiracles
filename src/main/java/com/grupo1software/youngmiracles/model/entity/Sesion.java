package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sesiones")
@Inheritance(strategy = InheritanceType.JOINED)

public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fecha;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_SESION_ADULTOMAYOR"))
    private AdultoMayor adultoMayor;
    @ManyToOne
    @JoinColumn(name = "voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_SESION_VOLUNTARIO"))
    private Voluntario voluntario;
    private Integer duracion;
}
