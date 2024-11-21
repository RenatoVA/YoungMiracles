package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class UpdateUsuarioResponseDTO {
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private Integer edad;
    private String genero;
    private String correo;
}