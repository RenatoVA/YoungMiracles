package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "familiares")
public class Familiar extends Usuario {
    private String relacionConAdulto;
    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_FAMILIAR_ADULTOMAYOR"))
    private AdultoMayor usuarioAsociado;
}
