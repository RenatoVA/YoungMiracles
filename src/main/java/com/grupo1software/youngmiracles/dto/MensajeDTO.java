package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.Familiar;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MensajeDTO {

    private Long id;
    @NotBlank(message= "El mensaje es obligatorio")
    private String texto;
    @NotBlank(message= "El voluntario es obligatorio")
    private Voluntario voluntario;
    @NotBlank(message= "El familiar es obligatorio")
    private Familiar familiar;
    private LocalDateTime fechaEnvio;
}
