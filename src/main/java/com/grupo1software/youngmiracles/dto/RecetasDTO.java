package com.grupo1software.youngmiracles.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecetasDTO {
    private Long id;
    private String nombreReceta;
    private String ingredientes;
    private String instrucciones;
    private LocalDateTime fechaCreacion;
}
