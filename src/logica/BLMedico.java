/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.*;
import entidades.*;
import excepciones.DatosInvalidosException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author samue
 */
public class BLMedico {

    public static boolean registrarMedico(String dni, String nombres, String apellidos, LocalDate fechaNacimiento, char sexo, String telefono, String direccion, String numeroColegiatura, String especialidad) throws Exception {

        if (dni == null || dni.trim().length() != 8 || !dni.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El DNI debe tener exactamente 8 números.");
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new DatosInvalidosException("Los nombres son obligatorios.");
        }
        if (apellidos == null || apellidos.trim().isEmpty()) {
            throw new DatosInvalidosException("Los apellidos son obligatorios.");
        }
        if (numeroColegiatura == null || numeroColegiatura.trim().isEmpty()) {
            throw new DatosInvalidosException("El número de colegiatura (CMP) es obligatorio para registrar un médico.");
        }
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new DatosInvalidosException("Debe asignar una especialidad al médico.");
        }
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now().minusYears(20))) {
             throw new DatosInvalidosException("Fecha de nacimiento inválida. El médico debe ser mayor de edad.");
        }

        Medico med = new Medico();
        med.setDni(dni.trim());
        med.setNombres(nombres.trim());
        med.setApellidos(apellidos.trim());
        med.setFechaNacimiento(fechaNacimiento);
        med.setSexo(sexo);
        med.setTelefono(telefono != null ? telefono.trim() : "");
        med.setDireccion(direccion != null ? direccion.trim() : "");
        med.setNumeroColegiatura(numeroColegiatura.trim());
        med.setEspecialidad(especialidad.trim());
        med.setActivo(true);

        return DALMedico.registrarMedico(med);
    }

    public static List<Medico> consultarMedicosActivos() throws Exception {
        List<Medico> lista = DALMedico.consultarMedicosActivos();
        
        if (lista.isEmpty()) {
            throw new DatosInvalidosException("No hay médicos activos registrados en el sistema en este momento.");
        }
        return lista;
    }
}
