package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="videollamadas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Videollamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name="adulto_mayor_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_VIDEOLLAMADA_ADULTOMAYOR"))
    private AdultoMayor adultoMayor;
    private Integer duracion;
    @ManyToOne
    @JoinColumn(name="voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_VIDEOLLAMADA_VOLUNTARIO"))
    private Voluntario voluntario;
    private String asunto;

}
