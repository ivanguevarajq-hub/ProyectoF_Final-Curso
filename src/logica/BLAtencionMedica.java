/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.DALAtencionMedica;
import entidades.AtencionMedica;
import entidades.Cita;
import java.util.*;
import excepciones.DatosInvalidosException;

/**
 *
 * @author samue
 */
public class BLAtencionMedica {

    public static boolean registrarAtencion(Cita cita, String motivoConsulta, String antecedentes, String signosVitales, String diagnostico, String tratamiento, String observaciones) throws Exception {
  
        if (cita == null || cita.getIdCita() <= 0) {
            throw new DatosInvalidosException("La atención médica debe estar asociada a una cita válida registrada.");
        }

        if (cita.getEstado() != Cita.EstadoCita.CONFIRMADA) {
             throw new DatosInvalidosException("No se puede registrar la atención porque la cita no se encuentra confirmada.");
        }

        if (motivoConsulta == null || motivoConsulta.trim().isEmpty()) {
            throw new DatosInvalidosException("El motivo de la consulta no puede estar vacío.");
        }

        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            throw new DatosInvalidosException("El diagnóstico es estrictamente obligatorio para cerrar la atención médica.");
        }

        AtencionMedica atencion = new AtencionMedica.Builder()
                .cita(cita)
                .motivoConsulta(motivoConsulta.trim())
                .antecedentes(antecedentes != null ? antecedentes.trim() : "")
                .signosVitales(signosVitales != null ? signosVitales.trim() : "")
                .diagnostico(diagnostico.trim())
                .tratamiento(tratamiento != null ? tratamiento.trim() : "")
                .observaciones(observaciones != null ? observaciones.trim() : "")
                .build();
                
        return DALAtencionMedica.registrarAtencion(atencion);
    }
    public static List<AtencionMedica> obtenerAtencionesPorHistoria(String numeroHistoriaClinica) throws Exception {

        if (numeroHistoriaClinica == null || numeroHistoriaClinica.trim().isEmpty()) {
            throw new DatosInvalidosException("El número de historia clínica es obligatorio para realizar la búsqueda.");
        }
        
        List<AtencionMedica> atenciones = DALAtencionMedica.obtenerAtencionesPorHistoria(numeroHistoriaClinica.trim());

        if (atenciones == null || atenciones.isEmpty()) {
            throw new DatosInvalidosException("No se encontraron atenciones médicas registradas para la historia clínica: " + numeroHistoriaClinica);
        }
        
        return atenciones;
    }
    public static boolean registrarReceta(int idAtencion, int idMedicamento, int cantidad, String indicaciones) throws Exception {

        if (idAtencion <= 0) {
            throw new DatosInvalidosException("ID de atención médica inválido.");
        }

        if (idMedicamento <= 0) {
            throw new DatosInvalidosException("Debe seleccionar un medicamento del catálogo.");
        }

        if (cantidad <= 0) {
            throw new DatosInvalidosException("La cantidad recetada debe ser mayor a cero.");
        }
    
        if (indicaciones == null || indicaciones.trim().isEmpty()) {
            throw new DatosInvalidosException("Las indicaciones para el paciente son obligatorias.");
        }
        
        return DALAtencionMedica.registrarReceta(idAtencion, idMedicamento, cantidad, indicaciones.trim());
    }
}