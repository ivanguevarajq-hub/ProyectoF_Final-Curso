/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author samue
 */
public class DALAuditoria {

    public static boolean registrarAccionAuditoria(String usuario, String modulo, String operacion) {
        String sql = "INSERT INTO Auditoria (usuario, fechaHora, modulo, operacion) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, usuario);
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(3, modulo);
            ps.setString(4, operacion);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar auditoría: " + e.getMessage());
            return false;
        }
    }
}
