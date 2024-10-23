package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.FacturaCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.FacturaResponseDTO;

public interface AdminFacturaService {
    FacturaResponseDTO getFactura(Long id);
    FacturaResponseDTO createFactura(FacturaCreateUpdateDTO facturaCreateUpdateDTO);
    FacturaResponseDTO confirmPurchase(Long id);
    void deleteFactura(Long id);
}
