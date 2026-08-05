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

        if (telefono == null || telefono.trim().length() != 9 || !telefono.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El número de teléfono debe tener exactamente 9 dígitos numéricos.");
        }

        if (direccion == null || direccion.trim().isEmpty()) {
            throw new DatosInvalidosException("La dirección es obligatoria.");
        }

        if (fechaNacimiento.isAfter(java.time.LocalDate.now())) {
            throw new DatosInvalidosException("El año ingresado es inválido. La fecha de nacimiento no puede ser del futuro.");
        }

        int edad = java.time.Period.between(fechaNacimiento, java.time.LocalDate.now()).getYears();

        if (edad < 24) {
            throw new DatosInvalidosException("Un médico colegiado debe tener al menos 24 años (incluyendo carrera y SERUMS).");
        }
        if (edad > 75) {
            throw new DatosInvalidosException("La edad del médico (" + edad + " años) excede el límite establecido para ejercer (75 años).");
        }

        Medico med = new Medico();
        med.setDni(dni.trim());
        med.setNombres(nombres.trim());
        med.setApellidos(apellidos.trim());
        med.setFechaNacimiento(fechaNacimiento);
        med.setSexo(sexo);
        med.setTelefono(telefono.trim());
        med.setDireccion(direccion.trim());
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

    public static Medico obtenerMedicoPorDni(String dni) throws Exception {

        if (dni == null || dni.trim().isEmpty() || dni.trim().length() != 8) {
            throw new DatosInvalidosException("Debe ingresar un DNI valido para continuar.");
        }
        Medico medico = DALMedico.obtenerMedicoPorDni(dni);
        if (medico == null) {
            throw new DatosInvalidosException("No se encontró medico con ese dni.");
        }
        return medico;
    }

    public static Medico obtenerMedicoPorColegiatura(String colegiatura) throws Exception {
        if (colegiatura == null || colegiatura.trim().isEmpty()) {
            throw new DatosInvalidosException("Debe ingresar un numero de Colegiatura valido para continuar.");
        }
        Medico medico = DALMedico.obtenerMedicoPorColegiatura(colegiatura);
        if (medico == null) {
            throw new DatosInvalidosException("No se encontró medico con ese numero de Colegiatura.");
        }
        return medico;
    }
}
