package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "recordatorios_sesiones")
public class RecordatorioSesion extends Recordatorio {

    @OneToOne
    @JoinColumn(name = "sesion_id", referencedColumnName = "id",foreignKey = @ForeignKey (name="FK_RECORDATORIOSESION_SESION"))
    private Sesion sesion;
}
