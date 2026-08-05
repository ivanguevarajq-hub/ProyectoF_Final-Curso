/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Medicamento;
import entidades.Receta;
import excepciones.DatosInvalidosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    
    public static List<Medicamento> listarMedicamentos(String filtro) {
        List<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT idMedicamento, nombre, stockActual, stockMinimo FROM Medicamentos "
                + "WHERE nombre LIKE ?";

        try (Connection conn = Conexion.getInstancia().realizarConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + filtro + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Medicamento(
                            rs.getInt("idMedicamento"),
                            rs.getString("nombre"),
                            rs.getInt("stockActual"),
                            rs.getInt("stockMinimo")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar medicamentos: " + e.getMessage());
        }
        return lista;
    }

    public static Receta buscarRecetaPorDniOAtencion(String filtro) throws Exception {
        if (filtro == null || filtro.trim().isEmpty()) {
            throw new DatosInvalidosException("Debe ingresar un DNI o N° de Atención.");
        }
        
        return null;
    }
}