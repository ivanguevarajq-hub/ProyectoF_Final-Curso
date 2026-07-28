/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */

public class DALPaciente {

    public boolean registrarPaciente(Paciente paciente) {
        String sql = "INSERT INTO Pacientes (dni, nombres, apellidos, fechaNacimiento, sexo, telefono, direccion, apoderado, numeroHistoriaClinica, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, paciente.getDni());
            ps.setString(2, paciente.getNombres());
            ps.setString(3, paciente.getApellidos());
            ps.setDate(4, Date.valueOf(paciente.getFechaNacimiento()));
            ps.setString(5, String.valueOf(paciente.getSexo()));
            ps.setString(6, paciente.getTelefono());
            ps.setString(7, paciente.getDireccion());
            ps.setString(8, paciente.getApoderado());
            ps.setString(9, paciente.getNumeroHistoriaClinica());
            ps.setString(10, paciente.getEstado().name());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar paciente: " + e.getMessage());
            return false;
        }
    }

    public boolean modificarPaciente(Paciente paciente) {
        String sql = "UPDATE Pacientes SET telefono = ?, direccion = ?, apoderado = ? WHERE dni = ?";
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, paciente.getTelefono());
            ps.setString(2, paciente.getDireccion());
            ps.setString(3, paciente.getApoderado());
            ps.setString(4, paciente.getDni());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar paciente: " + e.getMessage());
            return false;
        }
    }

    public List<Paciente> buscarPacientes(String parametroBusqueda) {
        List<Paciente> lista = new ArrayList<>();

        String sql = "SELECT * FROM Pacientes WHERE dni LIKE ? OR nombres LIKE ? OR numeroHistoriaClinica LIKE ? AND estado = 'ACTIVO'";
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            String filtro = "%" + parametroBusqueda + "%";
            ps.setString(1, filtro);
            ps.setString(2, filtro);
            ps.setString(3, filtro);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Paciente p = new Paciente();
                    p.setDni(rs.getString("dni"));
                    p.setNombres(rs.getString("nombres"));
                    p.setApellidos(rs.getString("apellidos"));
                    p.setNumeroHistoriaClinica(rs.getString("numeroHistoriaClinica"));
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar pacientes: " + e.getMessage());
        }
        return lista;
    }
}