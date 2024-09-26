package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="retroalimentaciones")
@Inheritance(strategy = InheritanceType.JOINED)
public class Retroalimentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private Integer puntaje;
    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_RETROALIMENTACION_ADULTOMAYOR"))
    private AdultoMayor adultoMayor;
    @ManyToOne
    @JoinColumn(name = "voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_RETROALIMENTACION_VOLUNTARIO"))
    private Voluntario voluntario;
}
