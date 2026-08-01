/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.*;
import entidades.*;
import excepciones.DatosInvalidosException;
import java.time.*;
import java.util.List;

/**
 *
 * @author samue
 */
public class BLPaciente {

    public static boolean registrarPaciente(String dni, String nombres, String apellidos, LocalDate fechaNacimiento, char sexo, String telefono, String direccion, String apoderado, String numeroHistoriaClinica) throws Exception {

        if (dni == null || dni.trim().length() != 8 || !dni.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El DNI debe contener exactamente 8 números.");
        }
        if (nombres == null || nombres.trim().isEmpty() || nombres.startsWith(" ")) {
            throw new DatosInvalidosException("Los nombres son obligatorios.");
        }
        if (apellidos == null || apellidos.trim().isEmpty() || apellidos.startsWith(" ")) {
            throw new DatosInvalidosException("Los apellidos son obligatorios.");
        }
        if (telefono == null || telefono.trim().length() != 9 || !telefono.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El teléfono debe contener exactamente 9 números.");
        }
        if (fechaNacimiento == null) {
            throw new DatosInvalidosException("La fecha de nacimiento es obligatoria.");
        }

        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        if (edad < 18 && (apoderado == null || apoderado.trim().isEmpty())) {
            throw new DatosInvalidosException("El paciente es menor de edad, el nombre del apoderado es obligatorio.");
        }

        Paciente pac = new Paciente.Builder()
                .dni(dni.trim())
                .nombres(nombres.trim())
                .apellidos(apellidos.trim())
                .fechaNacimiento(fechaNacimiento)
                .sexo(sexo)
                .telefono(telefono.trim())
                .direccion(direccion != null ? direccion.trim() : "")
                .apoderado(apoderado != null ? apoderado.trim() : "")
                .numeroHistoriaClinica(numeroHistoriaClinica != null ? numeroHistoriaClinica.trim() : "")
                .estado(Paciente.EstadoPaciente.ACTIVO)
                .build();

        return DALPaciente.registrarPaciente(pac);
    }

    public static boolean modificarPaciente(String dni, String telefono, String direccion, String apoderado) throws Exception {
        
        if (dni == null || dni.trim().length() != 8 || !dni.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El DNI proporcionado para modificar no es válido.");
        }
        if (telefono == null || telefono.trim().length() != 9 || !telefono.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El nuevo teléfono debe contener exactamente 9 números.");
        }
        Paciente pac = new Paciente.Builder()
                .dni(dni.trim())
                .telefono(telefono.trim())
                .direccion(direccion != null ? direccion.trim() : "")
                .apoderado(apoderado != null ? apoderado.trim() : "")
                .build();

        boolean exito = DALPaciente.modificarPaciente(pac);
        if (!exito) {
            throw new DatosInvalidosException("No se pudo modificar. Verifique que el paciente exista.");
        }
        return exito;
    }

    public static List<Paciente> buscarPacientes(String parametroBusqueda) throws Exception {
        if (parametroBusqueda == null || parametroBusqueda.trim().isEmpty()) {
            throw new DatosInvalidosException("Debe ingresar un DNI, nombre o historia clínica para buscar.");
        }

        List<Paciente> resultados = DALPaciente.buscarPacientes(parametroBusqueda.trim());

        if (resultados.isEmpty()) {
            throw new DatosInvalidosException("No se encontraron pacientes con ese criterio de búsqueda.");
        }
        return resultados;
    }
}