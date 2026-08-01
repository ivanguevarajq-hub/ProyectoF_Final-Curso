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
public class BLFarmacia {

    public static int consultarStock(int idMedicamento) throws Exception {
        if (idMedicamento <= 0) {
            throw new DatosInvalidosException("El ID del medicamento no es válido.");
        }
        
        return DALFarmacia.consultarStockMedicamento(idMedicamento);
    }

    public static boolean entregarMedicamento(int idMedicamento, int cantidadRequerida) throws Exception {
        if (idMedicamento <= 0) {
            throw new DatosInvalidosException("Debe seleccionar un medicamento válido.");
        }
        if (cantidadRequerida <= 0) {
            throw new DatosInvalidosException("La cantidad a entregar debe ser mayor a cero.");
        }
        
        int stockActual = DALFarmacia.consultarStockMedicamento(idMedicamento);
        
        if (stockActual == 0) {
            throw new DatosInvalidosException("El medicamento seleccionado se encuentra agotado (Stock: 0).");
        }
        if (stockActual < cantidadRequerida) {
            throw new DatosInvalidosException("Stock insuficiente. Solo quedan " + stockActual + " unidades disponibles.");
        }


        boolean exito = DALFarmacia.entregarMedicamento(idMedicamento, cantidadRequerida);
        
        if (!exito) {
            throw new DatosInvalidosException("Ocurrió un error al intentar actualizar el inventario.");
        }
        
        return exito;
    }
}
