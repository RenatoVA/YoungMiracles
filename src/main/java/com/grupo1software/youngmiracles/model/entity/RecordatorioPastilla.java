package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "recordatorios_pastillas")
public class RecordatorioPastilla extends Recordatorio {

    private String nombrePastilla;
    private Integer dosis;
    private LocalDateTime fecha;
}
