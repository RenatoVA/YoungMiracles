package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name="reportes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "progreso_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_REPORTE_PROGRESO"))
    private Progreso progreso;
    @ManyToOne
    @JoinColumn(name = "voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_REPORTE_VOLUNTARIO"))
    private Voluntario voluntario;
    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_REPORTE_ADULTOMAYOR"))
    private AdultoMayor adultoMayor;
    private String descripcion;
    private LocalDateTime fecha;
}
