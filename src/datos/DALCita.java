/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Cita;
import entidades.Paciente;
import java.sql.*;

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

    public static Cita obtenerDatosCita(int idCita) {
        String sql = "Select * from Citas WHERE idCita = ?";
        Cita cita = null;
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cita = new Cita();
                    cita.setIdCita(rs.getInt("idCita"));
                    cita.setFecha(rs.getDate("fecha").toLocalDate());
                    cita.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                    cita.setHoraFin(rs.getTime("horaFin").toLocalTime());
                    cita.setEstado(Cita.EstadoCita.valueOf(rs.getString("estado")));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al cancelar cita: " + e.getMessage());
        }
        return cita;
    }

    public static Cita obtenerDatosCitaConPaciente(int idCita) {
        // Si tus columnas de nombres/apellidos están directo en la tabla Pacientes, 
        // quita el JOIN con Personas y usa solo: INNER JOIN Pacientes pac ON c.dni_paciente = pac.dni
        String sql = "SELECT c.*, p.dni, p.nombres, p.apellidos "
                + "FROM Citas c "
                + "INNER JOIN Pacientes pac ON c.dni_paciente = pac.dni "
                + "INNER JOIN Personas p ON pac.dni = p.dni "
                + "WHERE c.idCita = ?";

        Cita cita = null;
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCita);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cita = new Cita();
                    cita.setIdCita(rs.getInt("idCita"));
                    cita.setFecha(rs.getDate("fecha").toLocalDate());
                    cita.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                    cita.setHoraFin(rs.getTime("horaFin").toLocalTime());
                    cita.setEstado(Cita.EstadoCita.valueOf(rs.getString("estado")));

                    // Creamos el objeto Paciente para que no venga nulo
                    Paciente paciente = new Paciente.Builder()
                            .dni(rs.getString("dni"))
                            .nombres(rs.getString("nombres"))
                            .apellidos(rs.getString("apellidos"))
                            .build();

                    cita.setPaciente(paciente);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener datos completos de la cita: " + e.getMessage());
        }
        return cita;
    }

}
