/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class DALFarmacia {

    public static Medicamento obtenerMedicamento(int idMedicamento) {
        String sql = "SELECT * FROM Medicamentos WHERE idMedicamento = ?";
        Medicamento med = null;
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idMedicamento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    med = new Medicamento(
                            rs.getInt("idMedicamento"),
                            rs.getString("nombre"),
                            rs.getInt("stockActual"),
                            rs.getInt("stockMinimo")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar medicamento: " + e.getMessage());
        }
        return med;
    }

    public static int consultarStockMedicamento(int idMedicamento) {
        Medicamento med = obtenerMedicamento(idMedicamento);
        return med != null ? med.getStockActual() : 0;
    }

    public static boolean entregarMedicamento(int idMedicamento, int cantidadEntregada) {
        String sql = "UPDATE Medicamentos SET stockActual = stockActual - ? WHERE idMedicamento = ? AND stockActual >= ?";
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, cantidadEntregada);
            ps.setInt(2, idMedicamento);
            ps.setInt(3, cantidadEntregada); 

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al entregar medicamento: " + e.getMessage());
            return false;
        }
    }
}