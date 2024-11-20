package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.CreateUpdateHorarioDTO;
import com.grupo1software.youngmiracles.dto.HorarioResponseDTO;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.mapper.HorarioMapper;
import com.grupo1software.youngmiracles.model.entity.Horario;
import com.grupo1software.youngmiracles.model.entity.Usuario;
import com.grupo1software.youngmiracles.model.entity.Voluntario;
import com.grupo1software.youngmiracles.repository.HorarioRepository;
import com.grupo1software.youngmiracles.repository.UsuarioRepository;
import com.grupo1software.youngmiracles.service.AdminHorarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminHorarioServiceImpl implements AdminHorarioService {
    private final HorarioRepository horarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final HorarioMapper horarioMapper;

    @Transactional
    @Override
    public HorarioResponseDTO createHorario(CreateUpdateHorarioDTO createUpdateHorarioDTO) {
        Voluntario voluntario = (Voluntario) usuarioRepository.findById(createUpdateHorarioDTO.getVoluntario_id())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado o no es un voluntario"));
        Horario nuevohorario=horarioMapper.toEntity(createUpdateHorarioDTO,voluntario);
        return horarioMapper.toDTO(horarioRepository.save(nuevohorario));
    }

    @Transactional(readOnly = true)
    @Override
    public HorarioResponseDTO getHorarioById(Long id) {
        return horarioMapper.toDTO(horarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Horario no encontrada con el ID: " + id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<HorarioResponseDTO> getAllHorarios() {
        List<Horario> horarios=horarioRepository.findAll();
        return horarios.stream().map(horarioMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<HorarioResponseDTO> getHorariosByVoluntario(Long voluntarioId) {
        List<Horario> horarios=horarioRepository.findByVoluntarioId(voluntarioId);
        return horarios.stream().map(horarioMapper::toDTO).toList();
    }

    @Override
    public List<HorarioResponseDTO> getHorariosByespecialidad(String especialidad) {
        List<Voluntario> voluntarios = usuarioRepository.findVoluntariosByEspecialidad(especialidad);

        // Mapea los horarios de todos los voluntarios a una lista de HorarioResponseDTO
        List<HorarioResponseDTO> horarios = voluntarios.stream()
                .flatMap(voluntario -> {
                    // Obtiene los horarios del voluntario
                    List<Horario> horariosVoluntario = horarioRepository.findByVoluntarioId(voluntario.getId());

                    // Convierte los horarios a DTOs
                    return horariosVoluntario.stream()
                            .map(horarioMapper::toDTO); // Usa el mapper para convertir a HorarioResponseDTO
                })
                .toList();

        return horarios;
    }

    @Transactional
    @Override
    public HorarioResponseDTO updateHorario(Long id, CreateUpdateHorarioDTO createUpdateHorarioDTO) {
        Horario h = horarioRepository.findById(id).orElse(null);
        if (h != null) {
            h.setFecha(createUpdateHorarioDTO.getFecha());
            Voluntario voluntario = (Voluntario) usuarioRepository.findById(createUpdateHorarioDTO.getVoluntario_id())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado o no es un voluntario"));
            h.setVoluntario(voluntario);
            h.setHora_fin(createUpdateHorarioDTO.getHora_fin());
            h.setHora_inicio(createUpdateHorarioDTO.getHora_inicio());
            return horarioMapper.toDTO(horarioRepository.save(h));
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteHorario(Long id) {
        horarioRepository.deleteById(id);
    }
}
