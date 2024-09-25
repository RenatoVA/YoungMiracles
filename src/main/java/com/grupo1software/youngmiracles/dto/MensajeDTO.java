package com.grupo1software.youngmiracles.dto;

import com.grupo1software.youngmiracles.model.entity.Familiar;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MensajeDTO {

    private Long id;
    private String texto;
    private Voluntario voluntario;
    private Familiar familiar;
    private LocalDateTime fechaEnvio;
}
