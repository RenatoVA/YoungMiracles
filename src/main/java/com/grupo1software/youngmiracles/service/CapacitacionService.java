package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.CapacitacionDTO;
import java.util.List;

public interface CapacitacionService {
    List<CapacitacionDTO> getAllCapacitaciones();
    CapacitacionDTO getCapacitacionById(Long id);
    CapacitacionDTO createCapacitacion(CapacitacionDTO capacitacionDTO);
    CapacitacionDTO updateCapacitacion(Long id, CapacitacionDTO capacitacionDTO);
    void deleteCapacitacion(Long id);
}
