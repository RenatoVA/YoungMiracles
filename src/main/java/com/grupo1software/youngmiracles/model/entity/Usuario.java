package com.grupo1software.youngmiracles.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Integer edad;
    private String genero;
    private String correo;
    private LocalDateTime fechaRegistro;
}