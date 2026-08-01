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
public class DALLaboratorio {

    public static boolean registrarResultado(int idExamen, String resultado) {
        String sql = "UPDATE ExamenesLaboratorio SET resultado = ?, estado = 'FINALIZADO' WHERE idExamen = ? AND estado != 'ENTREGADO'";
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, resultado);
            ps.setInt(2, idExamen);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar resultado de examen: " + e.getMessage());
            return false;
        }
    }
}
