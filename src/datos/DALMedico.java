/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Medico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */
public class DALMedico {

    public static boolean registrarMedico(Medico medico) {
        String sql = "INSERT INTO Medicos (dni, nombres, apellidos, fechaNacimiento, sexo, telefono, direccion, numeroColegiatura, especialidad, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, medico.getDni());
            ps.setString(2, medico.getNombres());
            ps.setString(3, medico.getApellidos());
            ps.setDate(4, Date.valueOf(medico.getFechaNacimiento()));
            ps.setString(5, String.valueOf(medico.getSexo()));
            ps.setString(6, medico.getTelefono());
            ps.setString(7, medico.getDireccion());
            ps.setString(8, medico.getNumeroColegiatura());
            ps.setString(9, medico.getEspecialidad());
            ps.setBoolean(10, medico.isActivo());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar médico: " + e.getMessage());
            return false;
        }
    }

    public static List<Medico> consultarMedicosActivos() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Medicos WHERE activo = 1";

        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Medico m = new Medico();
                m.setDni(rs.getString("dni"));
                m.setNombres(rs.getString("nombres"));
                m.setApellidos(rs.getString("apellidos"));
                m.setNumeroColegiatura(rs.getString("numeroColegiatura"));
                m.setEspecialidad(rs.getString("especialidad"));
                m.setActivo(rs.getBoolean("activo"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar médicos: " + e.getMessage());
        }
        return lista;
    }

    public static boolean existeMedico(String dni) {
        String sql = "SELECT COUNT(*) FROM Medicos WHERE dni = ?";
        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de médico: " + e.getMessage());
        }
        return false;
    }

    public static Medico obtenerMedicoPorDni(String dni) {
        Medico medico = null;
        String sql = "SELECT * FROM Medicos WHERE dni = ? AND activo = 1";

        try (Connection cn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    medico = new Medico();
                    medico.setNumeroColegiatura(rs.getString("numeroColegiatura"));
                    medico.setDni(rs.getString("dni"));
                    medico.setNombres(rs.getString("nombres"));
                    medico.setApellidos(rs.getString("apellidos"));                    
                    medico.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    medico.setSexo(rs.getString("sexo").charAt(0));
                    medico.setTelefono(rs.getString("telefono"));
                    medico.setDireccion(rs.getString("direccion"));
                    medico.setEspecialidad(rs.getString("especialidad"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener médico: " + e.getMessage());
        }

        return medico;
    }
    public static Medico obtenerMedicoPorColegiatura(String colegiatura) {
        Medico medico = null;
        String sql = "SELECT * FROM Medicos WHERE numeroColegiatura = ? AND activo = 1";

        try (Connection cn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, colegiatura);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    medico = new Medico();
                    medico.setNumeroColegiatura(rs.getString("numeroColegiatura"));
                    medico.setDni(rs.getString("dni"));
                    medico.setNombres(rs.getString("nombres"));
                    medico.setApellidos(rs.getString("apellidos"));                    
                    medico.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    medico.setSexo(rs.getString("sexo").charAt(0));
                    medico.setTelefono(rs.getString("telefono"));
                    medico.setDireccion(rs.getString("direccion"));
                    medico.setEspecialidad(rs.getString("especialidad"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener médico: " + e.getMessage());
        }

        return medico;
    }
}
