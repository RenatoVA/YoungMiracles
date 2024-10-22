package com.grupo1software.youngmiracles.mapper;

import com.grupo1software.youngmiracles.dto.FacturaCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.FacturaResponseDTO;
import com.grupo1software.youngmiracles.model.entity.Factura;
import com.grupo1software.youngmiracles.model.enums.Servicio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FacturaMapper {
    private final ModelMapper modelMapper;
    public FacturaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Factura toEntity(FacturaCreateUpdateDTO facturaCreateUpdateDTO) {
        Factura factura = new Factura();
        factura.setServicio(Servicio.valueOf(facturaCreateUpdateDTO.getServicio()));
        return factura;
    }
    public FacturaResponseDTO tofacturaResponseDTO(Factura factura) {
        FacturaResponseDTO facturaResponseDTO = new FacturaResponseDTO();
        facturaResponseDTO.setEstado(String.valueOf(factura.getPaymentStatus()));
        facturaResponseDTO.setTotal(factura.getTotal());
        facturaResponseDTO.setFecha(factura.getFecha());
        facturaResponseDTO.setUsuarioId(factura.getAdultoMayor().getId());
        facturaResponseDTO.setVoluntarioId(factura.getVoluntario().getId());
        facturaResponseDTO.setFacturaId(factura.getId());
        facturaResponseDTO.setServicio(String.valueOf(factura.getServicio()));
        return facturaResponseDTO;
    }
}
