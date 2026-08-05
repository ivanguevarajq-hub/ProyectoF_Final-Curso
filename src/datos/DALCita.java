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
        String sql = "SELECT c.idCita, c.fecha, c.horaInicio, c.horaFin, c.estado, "
                + "p.dni, p.nombres AS pac_nombres, p.apellidos AS pac_apellidos "
                + "FROM Citas c "
                + "INNER JOIN Pacientes p ON c.dni_paciente = p.dni "
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

                    // Instanciamos el Paciente usando estrictamente su patrón Builder
                    Paciente paciente = new Paciente.Builder()
                            .dni(rs.getString("dni"))
                            .nombres(rs.getString("pac_nombres"))
                            .apellidos(rs.getString("pac_apellidos"))
                            .build();

                    cita.setPaciente(paciente);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener datos completos de la cita: " + e.getMessage());
        }

        return cita;
    }

    public static Cita buscarCitaProgramadaPorDni(String dni) {
        String sql = "SELECT c.idCita, c.fecha, c.horaInicio, c.horaFin, c.estado, "
                + "p.dni, p.nombres AS pac_nombres, p.apellidos AS pac_apellidos "
                + "FROM Citas c "
                + "INNER JOIN Pacientes p ON c.dni_paciente = p.dni "
                + "WHERE c.dni_paciente = ? AND c.estado = 'PROGRAMADA' "
                + "ORDER BY c.fecha ASC, c.horaInicio ASC LIMIT 1";

        Cita cita = null;

        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cita = new Cita();
                    cita.setIdCita(rs.getInt("idCita"));
                    cita.setFecha(rs.getDate("fecha").toLocalDate());
                    cita.setHoraInicio(rs.getTime("horaInicio").toLocalTime());
                    cita.setHoraFin(rs.getTime("horaFin").toLocalTime());
                    cita.setEstado(Cita.EstadoCita.valueOf(rs.getString("estado")));

                    Paciente paciente = new Paciente.Builder()
                            .dni(rs.getString("dni"))
                            .nombres(rs.getString("pac_nombres"))
                            .apellidos(rs.getString("pac_apellidos"))
                            .build();

                    cita.setPaciente(paciente);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar cita por DNI: " + e.getMessage());
        }

        return cita;
    }

    public static boolean cambiarEstado(int idCita, String nuevoEstado) throws Exception {
        String sql = "UPDATE Citas SET estado = ? WHERE idCita = ?";

        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idCita);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al cambiar estado en DALCita: " + e.getMessage());
            throw e;
        }
    }
}
