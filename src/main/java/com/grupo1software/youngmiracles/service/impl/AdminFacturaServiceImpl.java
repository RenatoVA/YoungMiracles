package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.FacturaCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.FacturaResponseDTO;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.mapper.FacturaMapper;
import com.grupo1software.youngmiracles.model.entity.AdultoMayor;
import com.grupo1software.youngmiracles.model.entity.Factura;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import com.grupo1software.youngmiracles.model.enums.PaymentStatus;
import com.grupo1software.youngmiracles.repository.FacturaRepository;
import com.grupo1software.youngmiracles.repository.UsuarioRepository;
import com.grupo1software.youngmiracles.service.AdminFacturaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminFacturaServiceImpl implements AdminFacturaService {
    private final FacturaRepository facturaRepository;
    private final FacturaMapper facturaMapper;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    @Override
    public FacturaResponseDTO getFactura(Long id) {
        return facturaMapper.tofacturaResponseDTO(facturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Factura no encontrada con el ID: " + id)));
    }

    @Override
    public List<FacturaResponseDTO> getAllFacturas() {
        List<Factura> facturas = facturaRepository.findAll();
        return facturas.stream().map(facturaMapper::tofacturaResponseDTO).toList();
    }

    @Override
    public FacturaResponseDTO createFactura(FacturaCreateUpdateDTO facturaCreateUpdateDTO) {
        HashMap<String, Float> tarifas = new HashMap<>();
        tarifas.put("FISIOTERAPIA", 100.0F);
        tarifas.put("TALLER", 80.0F);
        tarifas.put("NUTRICION", 120.0F);
        Factura factura = facturaMapper.toEntity(facturaCreateUpdateDTO);
        AdultoMayor adultoMayor= (AdultoMayor) usuarioRepository.findById(facturaCreateUpdateDTO.getUsuarioId()).orElseThrow(()-> new ResourceNotFoundException(("No se encontro un adulto mayor asociado a el ID:"+facturaCreateUpdateDTO.getUsuarioId())));
        Voluntario voluntario= (Voluntario) usuarioRepository.findById(facturaCreateUpdateDTO.getVoluntarioId()).orElseThrow(()-> new ResourceNotFoundException(("No se encontro un voluntario asociado a el ID:"+facturaCreateUpdateDTO.getVoluntarioId())));
        factura.setTotal(tarifas.get(facturaCreateUpdateDTO.getServicio()));
        factura.setFecha(LocalDateTime.now());
        factura.setPaymentStatus(PaymentStatus.PENDING);
        factura.setAdultoMayor(adultoMayor);
        factura.setVoluntario(voluntario);
        Factura savedFactura=facturaRepository.save(factura);
        return facturaMapper.tofacturaResponseDTO(savedFactura);
    }

    @Override
    public FacturaResponseDTO confirmPurchase(Long id) {
        Factura factura=facturaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Factura no encontrada con el ID: "+id));

        factura.setPaymentStatus(PaymentStatus.PAID);
        Factura savedFactura=facturaRepository.save(factura);
        return facturaMapper.tofacturaResponseDTO(savedFactura);
    }

    @Override
    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
