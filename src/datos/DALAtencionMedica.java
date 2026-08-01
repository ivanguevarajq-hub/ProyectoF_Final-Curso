/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.AtencionMedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class DALAtencionMedica {

    public static boolean registrarAtencion(AtencionMedica atencion) {
        String sql = "INSERT INTO AtencionesMedicas (idCita, motivoConsulta, antecedentes, signosVitales, diagnostico, tratamiento, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, atencion.getCita().getIdCita()); 
            ps.setString(2, atencion.getMotivoConsulta());
            ps.setString(3, atencion.getAntecedentes());
            ps.setString(4, atencion.getSignosVitales());
            ps.setString(5, atencion.getDiagnostico()); 
            ps.setString(6, atencion.getTratamiento());
            ps.setString(7, atencion.getObservaciones());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar atención médica: " + e.getMessage());
            return false;
        }
    }

    public static boolean registrarReceta(int idAtencion, int idMedicamento, int cantidad, String indicaciones) {
        String sql = "INSERT INTO Recetas (idAtencion, idMedicamento, cantidad, indicaciones) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idAtencion); 
            ps.setInt(2, idMedicamento); 
            ps.setInt(3, cantidad);
            ps.setString(4, indicaciones);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar receta: " + e.getMessage());
            return false;
        }
    }
}