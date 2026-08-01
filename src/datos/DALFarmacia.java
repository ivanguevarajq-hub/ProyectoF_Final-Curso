/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class DALFarmacia {

    public static int consultarStockMedicamento(int idMedicamento) {
        String sql = "SELECT stockActual FROM Medicamentos WHERE idMedicamento = ?";
        int stock = 0;
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idMedicamento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    stock = rs.getInt("stockActual");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar stock: " + e.getMessage());
        }
        return stock;
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
