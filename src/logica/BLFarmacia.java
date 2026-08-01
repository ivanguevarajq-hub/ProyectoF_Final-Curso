/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.DALFarmacia;
import entidades.Medicamento;
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

    public static String entregarMedicamento(int idMedicamento, int cantidadRequerida) throws Exception {
        if (idMedicamento <= 0) {
            throw new DatosInvalidosException("Debe seleccionar un medicamento válido.");
        }
        if (cantidadRequerida <= 0) {
            throw new DatosInvalidosException("La cantidad a entregar debe ser mayor a cero.");
        }
        
        Medicamento med = DALFarmacia.obtenerMedicamento(idMedicamento);
        
        if (med == null) {
            throw new DatosInvalidosException("El medicamento solicitado no existe en el catálogo.");
        }

        if (med.getStockActual() == 0) {
            throw new DatosInvalidosException("El medicamento seleccionado se encuentra agotado (Stock: 0).");
        }
        if (med.getStockActual() < cantidadRequerida) {
            throw new DatosInvalidosException("Stock insuficiente. Solo quedan " + med.getStockActual() + " unidades disponibles.");
        }

        boolean exito = DALFarmacia.entregarMedicamento(idMedicamento, cantidadRequerida);
        
        if (!exito) {
            throw new DatosInvalidosException("Ocurrió un error al intentar actualizar el inventario.");
        }

        int stockRestante = med.getStockActual() - cantidadRequerida;
        
        if (stockRestante <= med.getStockMinimo()) {
            return "ÉXITO: Medicamento entregado correctamente.\n¡ALERTA!: El inventario ha alcanzado el stock mínimo (" + stockRestante + " unidades restantes).";
        }
        
        return "ÉXITO: Medicamento entregado correctamente.";
    }
}