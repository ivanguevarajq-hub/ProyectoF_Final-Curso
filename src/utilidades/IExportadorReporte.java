/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author samue
 */
import java.util.Map;

public interface IExportadorReporte {
    boolean exportar(Map<String, Integer> datos, String rutaDestino) throws Exception;

}
