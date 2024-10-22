package com.grupo1software.youngmiracles.model.entity;

import com.grupo1software.youngmiracles.model.enums.PaymentStatus;
import com.grupo1software.youngmiracles.model.enums.Servicio;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float total;
    private LocalDateTime fecha;
    private Servicio servicio;
    private PaymentStatus paymentStatus;
    @ManyToOne
    @JoinColumn(name="usuario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_FACTURA_USUARIO"))
    private AdultoMayor adultoMayor;
    @ManyToOne
    @JoinColumn(name="voluntario_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="FK_FACTURA_VOLUNTARIO"))
    private Voluntario voluntario;



}
