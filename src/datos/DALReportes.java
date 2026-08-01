/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author samue
 */
public class DALReportes {
    public static Map<String, Integer> obtenerPacientesPorEspecialidad() {
        Map<String, Integer> reporte = new HashMap<>();

        String sql = "SELECT m.especialidad, COUNT(c.idCita) AS totalAtendidos " +
                     "FROM Citas c " +
                     "INNER JOIN Medicos m ON c.colegiatura_medico = m.numeroColegiatura " +
                     "WHERE c.estado = 'ATENDIDA' " +
                     "GROUP BY m.especialidad";
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                reporte.put(rs.getString("especialidad"), rs.getInt("totalAtendidos"));
            }
        } catch (SQLException e) {
            System.err.println("Error al generar reporte de especialidades: " + e.getMessage());
        }
        return reporte;
    }

    public static double obtenerIngresosDelDia(java.sql.Date fecha) {
        double totalIngresos = 0.0;
        String sql = "SELECT SUM(montoTotal) AS total FROM Comprobantes WHERE DATE(fechaHora) = ?";
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setDate(1, fecha);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalIngresos = rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al generar reporte de ingresos: " + e.getMessage());
        }
        return totalIngresos;
    }
}
