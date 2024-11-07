package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String token;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String role;
    private String typeuser;

}
