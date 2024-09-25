package com.grupo1software.youngmiracles.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="mensajes")
@Inheritance(strategy= InheritanceType.JOINED)
public class Mensaje {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String texto;
    @ManyToOne
    @JoinColumn(name = "voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_MENSAJE_VOLUNTARIO"))
    private Voluntario voluntario;
    @ManyToOne
    @JoinColumn(name = "familiar_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_MENSAJE_FAMILIAR"))
    private Familiar familiar;
    private LocalDateTime fechaEnvio;
}
