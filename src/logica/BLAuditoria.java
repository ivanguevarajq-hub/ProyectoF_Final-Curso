/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.DALAuditoria;
import excepciones.DatosInvalidosException;

/**
 *
 * @author samue
 */
public class BLAuditoria {

    public static boolean registrarAccion(String usuario, String modulo, String operacion) throws Exception {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new DatosInvalidosException("Error interno: El nombre de usuario es obligatorio para la auditoría.");
        }
        if (modulo == null || modulo.trim().isEmpty()) {
            throw new DatosInvalidosException("Error interno: Se debe especificar el módulo (Ej. PACIENTES, CITAS).");
        }
        if (operacion == null || operacion.trim().isEmpty()) {
            throw new DatosInvalidosException("Error interno: Se debe especificar la operación (Ej. REGISTRO, ACTUALIZACIÓN).");
        }

        DALAuditoria dal = new DALAuditoria();
        return dal.registrarAccionAuditoria(usuario.trim(), modulo.trim(), operacion.trim());
    }
}
