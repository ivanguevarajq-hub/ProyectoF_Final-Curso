/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Comprobante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author samue
 */
public class DALCaja {

    public boolean registrarPago(Comprobante comprobante) {
        String sql = "INSERT INTO Comprobantes (numeroComprobante, idAtencion, montoTotal, metodoPago, fechaHora) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, comprobante.getNumeroComprobante());
            ps.setInt(2, comprobante.getAtencionMedica().getIdAtencion());
            ps.setDouble(3, comprobante.getMontoTotal());
            ps.setString(4, comprobante.getMetodoPago().name()); 
            ps.setTimestamp(5, Timestamp.valueOf(comprobante.getFechaHora()));

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar pago: " + e.getMessage());
            return false;
        }
    }
}