package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.ReporteVoluntarioResponseDTO;
import com.grupo1software.youngmiracles.dto.SesionCreateUpdateDTO;
import com.grupo1software.youngmiracles.dto.SesionResponseDTO;
import com.grupo1software.youngmiracles.dto.SesionUpdateStateDTO;
import com.grupo1software.youngmiracles.exception.BadRequestException;
import com.grupo1software.youngmiracles.exception.ResourceNotFoundException;
import com.grupo1software.youngmiracles.integration.notification.email.dto.Mail;
import com.grupo1software.youngmiracles.integration.notification.email.service.EmailService;
import com.grupo1software.youngmiracles.mapper.SesionMapper;
import com.grupo1software.youngmiracles.model.entity.*;
import com.grupo1software.youngmiracles.repository.HorarioRepository;
import com.grupo1software.youngmiracles.repository.SesionRepository;
import com.grupo1software.youngmiracles.repository.UsuarioRepository;
import com.grupo1software.youngmiracles.service.AdminSesionService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AdminSesionServiceImpl implements AdminSesionService {

    private final SesionRepository sesionRepository;

    private final SesionMapper sesionMapper;
    private final UsuarioRepository usuarioRepository;
    private final HorarioRepository horarioRepository;
    private final EmailService emailService;
    @Transactional
    @Override
    public SesionResponseDTO createSesion(SesionCreateUpdateDTO sesionCreateUpdateDTO) {
        Sesion sesion = sesionMapper.toEntity(sesionCreateUpdateDTO);
        sesion.setFechaRegistro(LocalDate.now());
        AdultoMayor adultoMayor= (AdultoMayor) usuarioRepository.findById(sesionCreateUpdateDTO.getAdultoMayorId()).orElseThrow(() -> new ResourceNotFoundException("AdultoMayor no encontrado con el ID: " + sesionCreateUpdateDTO.getAdultoMayorId()));
        Voluntario voluntario= (Voluntario) usuarioRepository.findById(sesionCreateUpdateDTO.getVoluntarioId()).orElseThrow(() -> new ResourceNotFoundException("Voluntario no encontrado con el ID: " + sesionCreateUpdateDTO.getVoluntarioId()));
        Horario horario=  horarioRepository.findById(sesionCreateUpdateDTO.getHorarioId()).orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con el ID: " + sesionCreateUpdateDTO.getHorarioId()));
        horario.setDisponibilidad("ocupado");
        long horas=calcularDuracionEnHoras(horario.getHora_inicio(), horario.getHora_fin());
        sesion.setDuracion((int) horas);
        sesion.setAdultoMayor(adultoMayor);
        sesion.setHorario(horario);
        sesion.setVoluntario(voluntario);
        sesion.setFecha(horario.getFecha());
        Sesion sesioncreada=sesionRepository.save(sesion);
        enviarCorreoSesionAgendadaAdultoMayor(adultoMayor, sesioncreada);
        enviarCorreoSesionAgendadaVoluntario(voluntario, sesioncreada);
        return sesionMapper.toDTO(sesioncreada);
    }


    public static long calcularDuracionEnHoras(String horaInicio, String horaFin) {
        // Formato de hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parsear las cadenas a LocalTime
        LocalTime inicio = LocalTime.parse(horaInicio, formatter);
        LocalTime fin = LocalTime.parse(horaFin, formatter);

        // Calcular la diferencia en horas
        return ChronoUnit.HOURS.between(inicio, fin);
    }
    @Override
    public ReporteVoluntarioResponseDTO generarReportePorVoluntario(Long voluntarioId) {
        // Recuperar todas las sesiones del voluntario
        List<Sesion> sesiones = sesionRepository.findByVoluntarioId(voluntarioId);

        // Calcular las métricas
        int totalSesiones = sesiones.size();
        int completadas = (int) sesiones.stream().filter(s -> s.getEstado().equalsIgnoreCase("completado")).count();
        int canceladas = (int) sesiones.stream().filter(s -> s.getEstado().equalsIgnoreCase("cancelado")).count();
        int pendientes = (int) sesiones.stream().filter(s -> s.getEstado().equalsIgnoreCase("pendiente")).count();

        int horasTrabajadas = sesiones.stream()
                .filter(s -> s.getEstado().equalsIgnoreCase("completado"))
                .mapToInt(Sesion::getDuracion)
                .sum();

        LocalDate ultimaSesion = sesiones.stream()
                .filter(s -> s.getEstado().equalsIgnoreCase("completado"))
                .map(Sesion::getFecha)
                .max(LocalDate::compareTo)
                .orElse(null);

        double tasaCancelacion = totalSesiones == 0 ? 0 : ((double) canceladas / totalSesiones) * 100;

        // Crear el DTO con los datos calculados
        return new ReporteVoluntarioResponseDTO(
                totalSesiones,
                completadas,
                canceladas,
                pendientes,
                horasTrabajadas,
                ultimaSesion,
                tasaCancelacion
        );
    }


    private void enviarCorreoSesionAgendadaAdultoMayor(Usuario adultoMayor, Sesion sesion) {
        try {
            // Crear el modelo de datos para el correo
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", adultoMayor.getNombre() + " " + adultoMayor.getApellido_paterno());
            model.put("fecha", sesion.getFecha().toString());
            model.put("hora", sesion.getHorario().getHora_inicio());
            model.put("tipoSesion", sesion.getClass().getSimpleName()); // Fisioterapia, Taller, etc.
            model.put("voluntario", sesion.getVoluntario().getNombre() + " " + sesion.getVoluntario().getApellido_paterno());

            // Crear el correo
            Mail mail = emailService.createMail(
                    adultoMayor.getCorreo(), // Dirección del adulto mayor
                    "Sesión Agendada Satisfactoriamente", // Asunto del correo
                    model,
                    "noreply@youngmiracles.com" // Dirección de origen
            );

            // Enviar el correo usando una plantilla de Thymeleaf
            emailService.sendEmail(mail, "email/sesion-agendada-template");
        } catch (MessagingException e) {
            System.err.println("Error al enviar correo: " + e.getMessage());
        }
    }
    private void enviarCorreoSesionAgendadaVoluntario(Voluntario voluntario, Sesion sesion) {
        try {
            Map<String, Object> model = new HashMap<>();
            model.put("nombre", voluntario.getNombre() + " " + voluntario.getApellido_paterno());
            model.put("fecha", sesion.getFecha().toString());
            model.put("hora", sesion.getHorario().getHora_inicio());
            model.put("tipoSesion", sesion.getClass().getSimpleName());
            model.put("adultoMayor", sesion.getAdultoMayor().getNombre() + " " + sesion.getAdultoMayor().getApellido_paterno());

            Mail mail = emailService.createMail(
                    voluntario.getCorreo(),
                    "Nueva Sesión Asignada",
                    model,
                    "noreply@youngmiracles.com"
            );

            emailService.sendEmail(mail, "email/sesion-asignada-voluntario-template");
        } catch (MessagingException e) {
            System.err.println("Error al enviar correo al Voluntario: " + e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SesionResponseDTO getSesionById(Long id) {
        return sesionMapper.toDTO(sesionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sesion no encontrada con el ID: " + id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<SesionResponseDTO> getAllSesions() {
        return sesionRepository.findAll().stream().map(sesionMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public SesionResponseDTO updateSesion(Long id, SesionCreateUpdateDTO sesionactualizadoDTO) {

        Sesion sesionexistente=sesionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sesion no encontrado con el ID: " + id));


        Sesion sesionactualizado=sesionMapper.toEntity(sesionactualizadoDTO);

        sesionexistente.setEstado(sesionactualizado.getEstado());

        return sesionMapper.toDTO(sesionRepository.save(sesionexistente));
    }

    @Transactional
    @Override
    public void updateSesionState(SesionUpdateStateDTO sesionUpdateStateDTO){
        Sesion sesionexistente=sesionRepository.findById(sesionUpdateStateDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Sesion no encontrado con el ID: " + sesionUpdateStateDTO.getId()));
        sesionexistente.setEstado(sesionUpdateStateDTO.getState());
        Horario horario=horarioRepository.findById(sesionexistente.getHorario().getId()).orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con el ID:"+sesionexistente.getHorario().getId()));
        if (sesionUpdateStateDTO.getState()=="cancelado")
        {
            horario.setDisponibilidad("disponible");
        }
        if(sesionUpdateStateDTO.getState()=="completado"){
            horario.setDisponibilidad("terminado");
        }
        sesionRepository.save(sesionexistente);
        horarioRepository.save(horario);
    }

    @Transactional
    @Override
    public void deleteSesion(Long id) {
        sesionRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SesionResponseDTO> getSesionsByAdultoMayor(Long adultoMayorId) {
        return sesionRepository.findByAdultoMayorId(adultoMayorId).stream().map(sesionMapper::toDTO).toList();
    }


    @Transactional(readOnly = true)
    @Override
    public List<SesionResponseDTO> getSesionsByVoluntario(Long voluntarioId) {
        return sesionRepository.findByVoluntarioId(voluntarioId).stream().map(sesionMapper::toDTO).toList();
    }

    private void updateFisioterapia(Fisioterapia fisioterapia, Fisioterapia details) {
        fisioterapia.setTipoFisioterapia(details.getTipoFisioterapia());
        fisioterapia.setObservaciones(details.getObservaciones());
    }

    private void updateTaller(Taller taller, Taller details) {
        taller.setDescripcion(details.getDescripcion());
        taller.setCapacidadMaxima(details.getCapacidadMaxima());
        taller.setMaterialRequerido(details.getMaterialRequerido());
    }
    private void updateNutricion(Nutricion nutricion, Nutricion details) {
        nutricion.setIndicaciones(details.getIndicaciones());
        nutricion.setReceta(details.getReceta());
    }

}
