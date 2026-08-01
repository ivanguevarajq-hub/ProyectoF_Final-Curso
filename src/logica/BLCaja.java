/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.*;
import entidades.*;
import excepciones.DatosInvalidosException;
import java.time.LocalDateTime;

/**
 *
 * @author samue
 */
public class BLCaja {

    public static boolean registrarPago(int idAtencion, String numeroComprobante, double montoTotal, Comprobante.MetodoPago metodoPago) throws Exception {
        
        if (idAtencion <= 0) {
            throw new DatosInvalidosException("El pago debe estar asociado a un ID de atención médica válido.");
        }
        if (numeroComprobante == null || numeroComprobante.trim().isEmpty()) {
            throw new DatosInvalidosException("El número de comprobante es obligatorio (Ej. B001-0000123).");
        }
        if (montoTotal <= 0) {
            throw new DatosInvalidosException("El monto total a cobrar debe ser mayor a 0.");
        }
        if (metodoPago == null) {
            throw new DatosInvalidosException("Debe seleccionar un método de pago válido (Efectivo, Tarjeta, etc.).");
        }

        AtencionMedica atencion = new AtencionMedica();
        atencion.setIdAtencion(idAtencion);

        Comprobante comp = new Comprobante();
        comp.setAtencionMedica(atencion);
        comp.setNumeroComprobante(numeroComprobante.trim());
        comp.setMontoTotal(montoTotal);
        comp.setMetodoPago(metodoPago);
        comp.setFechaHora(LocalDateTime.now());

        boolean exito = DALCaja.registrarPago(comp);
        
        if (!exito) {
            throw new DatosInvalidosException("Error al registrar el pago. Asegúrese de que el número de comprobante no esté duplicado.");
        }
        return exito;
    }
}