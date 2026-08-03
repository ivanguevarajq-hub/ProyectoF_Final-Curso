package datos;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DALUsuario {

    public static Usuario autenticarUsuario(String nombreUsuario, String contrasena) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuarios WHERE nombreUsuario = ? AND contrasena = ? AND activo = 1";

        Connection conn = Conexion.getInstancia().realizarConexion();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena); 

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("idUsuario"));
                    usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuario.setRol(Usuario.RolUsuario.valueOf(rs.getString("rol").toUpperCase()));
                    usuario.setActivo(rs.getBoolean("activo"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al autenticar usuario: " + e.getMessage());
        }
        return usuario;
    }

    public static boolean registrarUsuario(Usuario usuario, String dni, String nombres, String apellidos) {
        String sql = "INSERT INTO Usuarios (dni, nombres, apellidos, nombreUsuario, contrasena, rol, activo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = Conexion.getInstancia().realizarConexion();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, dni);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, usuario.getNombreUsuario());
            ps.setString(5, usuario.getContrasena());
            ps.setString(6, usuario.getRol().name());
            ps.setBoolean(7, usuario.isActivo());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public static boolean bloquearUsuario(int idUsuario) {
        String sql = "UPDATE Usuarios SET activo = 0 WHERE idUsuario = ?";
        
        Connection conn = Conexion.getInstancia().realizarConexion();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al bloquear usuario: " + e.getMessage());
            return false;
        }
    }
}