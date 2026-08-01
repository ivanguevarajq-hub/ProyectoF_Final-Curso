/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.AtencionMedica;
import entidades.HistorialClinico;
import entidades.Paciente;
import java.util.List;

/**
 *
 * @author samue
 */
public class DALHistorialClinico {

    public static HistorialClinico obtenerHistorialCompleto(String parametroBusqueda) {

        List<Paciente> resultados = DALPaciente.buscarPacientes(parametroBusqueda);
        if (resultados == null || resultados.isEmpty()) {
            return null; 
        }
  
        Paciente paciente = resultados.get(0);

        List<AtencionMedica> historialAtenciones = DALAtencionMedica.obtenerAtencionesPorHistoria(paciente.getNumeroHistoriaClinica());

        return new HistorialClinico.Builder()
                .numeroHistoria(paciente.getNumeroHistoriaClinica())
                .paciente(paciente)
                .atenciones(historialAtenciones)
                .build();
    }
}