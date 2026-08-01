/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.*;
import excepciones.DatosInvalidosException;

/**
 *
 * @author samue
 */
public class BLLaboratorio {

    public static boolean registrarResultado(int idExamen, String resultado) throws Exception {
        if (idExamen <= 0) {
            throw new DatosInvalidosException("El ID del examen de laboratorio es inválido.");
        }
        if (resultado == null || resultado.trim().isEmpty()) {
            throw new DatosInvalidosException("El resultado del examen no puede estar vacío.");
        }

        boolean exito = DALLaboratorio.registrarResultado(idExamen, resultado.trim());
        
        if (!exito) {
            throw new DatosInvalidosException("No se pudo registrar el resultado. Verifique que el examen exista y no esté ya finalizado o entregado.");
        }
        return exito;
    }
}
