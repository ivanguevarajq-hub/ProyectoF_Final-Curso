/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Cita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class DALCita {

    public static boolean registrarCita(Cita cita) {
        String sql = "INSERT INTO Citas (idCita, dni_paciente, colegiatura_medico, fecha, horaInicio, horaFin, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cita.getIdCita());
            ps.setString(2, cita.getPaciente().getDni());
            ps.setString(3, cita.getMedico().getNumeroColegiatura());
            ps.setDate(4, Date.valueOf(cita.getFecha()));
            ps.setTime(5, Time.valueOf(cita.getHoraInicio()));
            ps.setTime(6, Time.valueOf(cita.getHoraFin()));
            ps.setString(7, Cita.EstadoCita.PROGRAMADA.name());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar cita: " + e.getMessage());
            return false;
        }
    }

    public static boolean reprogramarCita(int idCita, Date nuevaFecha, Time nuevaHoraInicio, Time nuevaHoraFin) {
        String sql = "UPDATE Citas SET fecha = ?, horaInicio = ?, horaFin = ?, estado = 'PROGRAMADA' WHERE idCita = ? AND estado != 'ATENDIDA'";
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, nuevaFecha);
            ps.setTime(2, nuevaHoraInicio);
            ps.setTime(3, nuevaHoraFin);
            ps.setInt(4, idCita);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al reprogramar cita: " + e.getMessage());
            return false;
        }
    }

    public static boolean cancelarCita(int idCita) {
        String sql = "UPDATE Citas SET estado = 'CANCELADA' WHERE idCita = ?";
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCita);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al cancelar cita: " + e.getMessage());
            return false;
        }
    }

    public static boolean obtenerCita(int idCita) {
        String sql = "Select * from Citas WHERE idCita = ?";
        Cita cita = null;
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCita);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al cancelar cita: " + e.getMessage());
            return false;
        }
    }
}
