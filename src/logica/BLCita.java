/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.*;
import entidades.*;
import excepciones.DatosInvalidosException;
import java.sql.*;
import java.time.*;

/**
 *
 * @author samue
 */
public class BLCita {

    public static boolean registrarCita(int idCita, Paciente paciente, Medico medico, LocalDate fecha, LocalTime horaInicio) throws Exception {

        if (idCita <= 0) {
            throw new DatosInvalidosException("Debe escribir un id válido.");
        }
        if (paciente == null || paciente.getDni() == null || paciente.getDni().trim().isEmpty()) {
            throw new DatosInvalidosException("Debe seleccionar un paciente registrado válido.");
        }
        if (medico == null || medico.getNumeroColegiatura() == null || medico.getNumeroColegiatura().trim().isEmpty()) {
            throw new DatosInvalidosException("Debe seleccionar un médico válido.");
        }
        if (fecha == null || fecha.isBefore(LocalDate.now())) {
            throw new DatosInvalidosException("La fecha de la cita no puede ser en el pasado.");
        }
        if (horaInicio == null) {
            throw new DatosInvalidosException("Debe establecer una hora de inicio.");
        }

        LocalTime horaApertura = LocalTime.of(8, 0);
        LocalTime horaCierre = LocalTime.of(20, 0);
        if (horaInicio.isBefore(horaApertura) || horaInicio.isAfter(horaCierre)) {
            throw new DatosInvalidosException("La cita debe registrarse dentro del horario de atención (08:00 a 20:00).");
        }
        LocalTime horaFin = horaInicio.plusMinutes(30);

        Cita cita = new Cita();
        cita.setIdCita(idCita);
        cita.setPaciente(paciente);
        cita.setMedico(medico);
        cita.setFecha(fecha);
        cita.setHoraInicio(horaInicio);
        cita.setHoraFin(horaFin);

        return DALCita.registrarCita(cita);
    }

    public static boolean reprogramarCita(int idCita, LocalDate nuevaFecha, LocalTime nuevaHoraInicio) throws Exception {
        if (idCita <= 0) {
            throw new DatosInvalidosException("ID de cita inválido para reprogramar.");
        }
        if (nuevaFecha == null || nuevaFecha.isBefore(LocalDate.now())) {
            throw new DatosInvalidosException("La nueva fecha no puede estar en el pasado.");
        }
        if (nuevaHoraInicio == null) {
            throw new DatosInvalidosException("La nueva hora de inicio es obligatoria.");
        }

        LocalTime horaApertura = LocalTime.of(8, 0);
        LocalTime horaCierre = LocalTime.of(20, 0);
        if (nuevaHoraInicio.isBefore(horaApertura) || nuevaHoraInicio.isAfter(horaCierre)) {
            throw new DatosInvalidosException("El nuevo horario debe estar entre las 08:00 y las 20:00.");
        }

        LocalTime nuevaHoraFin = nuevaHoraInicio.plusMinutes(30);

        boolean exito = DALCita.reprogramarCita(idCita, Date.valueOf(nuevaFecha), Time.valueOf(nuevaHoraInicio), Time.valueOf(nuevaHoraFin));

        if (!exito) {
            throw new DatosInvalidosException("No se pudo reprogramar la cita. Verifique que exista y no esté ya atendida.");
        }
        return exito;
    }

    public static boolean cancelarCita(int idCita) throws Exception {
        if (idCita <= 0) {
            throw new DatosInvalidosException("ID de cita inválido para cancelación.");
        }

        boolean exito = DALCita.cancelarCita(idCita);

        if (!exito) {
            throw new DatosInvalidosException("No se pudo cancelar la cita. Es posible que el ID no exista.");
        }
        return exito;
    }

    public static Cita obtenerDatosCita(int idCita) throws Exception {
        if (idCita <= 0) {
            throw new DatosInvalidosException("ID de Cita inválido.");
        }
        Cita cita = DALCita.obtenerDatosCita(idCita);

        if (cita == null) {
            throw new DatosInvalidosException("La cita no existe o fue cancelada.");
        }
        return cita;
    }

    public static Cita obtenerDatosCitaConPaciente(int idCita) throws Exception {
        if (idCita <= 0) {
            throw new DatosInvalidosException("ID de Cita inválido.");
        }

        Cita cita = DALCita.obtenerDatosCitaConPaciente(idCita);

        if (cita == null) {
            throw new DatosInvalidosException("La cita no existe o fue cancelada.");
        }
        return cita;
    }
}
