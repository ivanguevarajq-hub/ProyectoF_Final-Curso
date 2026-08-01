/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.*;
import excepciones.DatosInvalidosException;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author samue
 */
public class BLReportes {

    public static Map<String, Integer> obtenerPacientesPorEspecialidad() throws Exception {
        Map<String, Integer> reporte = DALReportes.obtenerPacientesPorEspecialidad();
        
        if (reporte == null || reporte.isEmpty()) {
            throw new DatosInvalidosException("Actualmente no hay datos suficientes de citas atendidas para generar el reporte de especialidades.");
        }
        return reporte;
    }

    public static double obtenerIngresosDelDia(LocalDate fecha) throws Exception {
        if (fecha == null) {
            throw new DatosInvalidosException("Debe proporcionar una fecha válida para la consulta.");
        }
        if (fecha.isAfter(LocalDate.now())) {
            throw new DatosInvalidosException("No se pueden consultar los ingresos de fechas futuras.");
        }

        return DALReportes.obtenerIngresosDelDia(java.sql.Date.valueOf(fecha));
    }
}
