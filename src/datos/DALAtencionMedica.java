/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.AtencionMedica;
import entidades.Cita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.err.println("Error en DALAtencionMedica al registrar atención: " + e.getMessage());
            return false;
        }
    }

    public static List<AtencionMedica> obtenerAtencionesPorHistoria(String numeroHistoriaClinica) {
        List<AtencionMedica> lista = new ArrayList<>();

        String sql = "SELECT a.*, c.idCita FROM AtencionesMedicas a " +
                     "INNER JOIN Citas c ON a.idCita = c.idCita " +
                     "INNER JOIN Pacientes p ON c.dniPaciente = p.dni " +
                     "WHERE p.numeroHistoriaClinica = ?";
        
        try (Connection conn = Conexion.getInstancia().realizarConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, numeroHistoriaClinica);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cita citaBase = new Cita();
                    citaBase.setIdCita(rs.getInt("idCita"));
                    AtencionMedica atencion = new AtencionMedica.Builder()
                            .idAtencion(rs.getInt("idAtencion"))
                            .cita(citaBase)
                            .motivoConsulta(rs.getString("motivoConsulta"))
                            .antecedentes(rs.getString("antecedentes"))
                            .signosVitales(rs.getString("signosVitales"))
                            .diagnostico(rs.getString("diagnostico"))
                            .tratamiento(rs.getString("tratamiento"))
                            .observaciones(rs.getString("observaciones"))
                            .build();
                            
                    lista.add(atencion);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en DALAtencionMedica al obtener atenciones: " + e.getMessage());
        }
        return lista;
    }

    public static boolean registrarReceta(int idAtencion, int idMedicamento, int cantidad, String indicaciones) {
        String sqlReceta = "INSERT INTO Recetas (idAtencion) VALUES (?)";
        String sqlDetalle = "INSERT INTO DetallesReceta (idReceta, idMedicamento, cantidad, indicaciones) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = Conexion.getInstancia().realizarConexion();
            conn.setAutoCommit(false); 

            int idRecetaGenerada = 0;

            try (PreparedStatement psReceta = conn.prepareStatement(sqlReceta, Statement.RETURN_GENERATED_KEYS)) {
                psReceta.setInt(1, idAtencion);
                psReceta.executeUpdate();
                
                try (ResultSet rsKeys = psReceta.getGeneratedKeys()) {
                    if (rsKeys.next()) {
                        idRecetaGenerada = rsKeys.getInt(1);
                    } else {
                        throw new SQLException("No se pudo obtener el ID de la receta generada.");
                    }
                }
            }

            try (PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle)) {
                psDetalle.setInt(1, idRecetaGenerada);
                psDetalle.setInt(2, idMedicamento);
                psDetalle.setInt(3, cantidad);
                psDetalle.setString(4, indicaciones);
                psDetalle.executeUpdate();
            }

            conn.commit(); 
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Revertir si hay error
                } catch (SQLException ex) {
                    System.err.println("Error al hacer rollback: " + ex.getMessage());
                }
            }
            System.err.println("Error en DALAtencionMedica al registrar receta: " + e.getMessage());
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar conexión: " + e.getMessage());
                }
            }
        }
    }
}