package logica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import datos.DALHistorialClinico;
import entidades.*;
import excepciones.DatosInvalidosException;

/**
 *
 * @author Lenovo
 */
public class BLHistorialClinico {

    public static HistorialClinico obtenerHistorialCompleto(String parametroBusqueda) throws Exception {
        if (parametroBusqueda == null || parametroBusqueda.trim().isEmpty()) {
            throw new DatosInvalidosException("Debe ingresar un parámetro de búsqueda (DNI, nombres o N° Historia).");
        }

        HistorialClinico historial = DALHistorialClinico.obtenerHistorialCompleto(parametroBusqueda.trim());

        if (historial == null) {
            throw new DatosInvalidosException("No se encontró ningún historial clínico con el criterio ingresado.");
        }

        return historial;
    }
}
