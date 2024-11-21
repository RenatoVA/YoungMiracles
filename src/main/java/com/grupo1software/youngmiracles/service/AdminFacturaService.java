package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.FacturaCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.FacturaResponseDTO;

import java.util.List;

public interface AdminFacturaService {
    FacturaResponseDTO getFactura(Long id);
    List<FacturaResponseDTO> getAllFacturas();
    FacturaResponseDTO createFactura(FacturaCreateUpdateDTO facturaCreateUpdateDTO);
    FacturaResponseDTO confirmPurchase(Long id);
    List<FacturaResponseDTO> getFacturasById(Long id);
    void deleteFactura(Long id);
}
