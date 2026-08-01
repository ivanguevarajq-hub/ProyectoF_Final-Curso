/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.*;
import entidades.*;
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
        if (motivoConsulta == null || motivoConsulta.trim().isEmpty()) {
            throw new DatosInvalidosException("El motivo de la consulta no puede estar vacío.");
        }
        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            throw new DatosInvalidosException("El diagnóstico es estrictamente obligatorio para cerrar la atención médica.");
        }

        AtencionMedica atencion = new AtencionMedica();
        atencion.setCita(cita);
        atencion.setMotivoConsulta(motivoConsulta.trim());
        atencion.setAntecedentes(antecedentes != null ? antecedentes.trim() : "");
        atencion.setSignosVitales(signosVitales != null ? signosVitales.trim() : "");
        atencion.setDiagnostico(diagnostico.trim());
        atencion.setTratamiento(tratamiento != null ? tratamiento.trim() : "");
        atencion.setObservaciones(observaciones != null ? observaciones.trim() : "");
        return DALAtencionMedica.registrarAtencion(atencion);
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
