/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.Map;
/**
 *
 * @author samue
 */
public class AdaptadorExcel implements IExportadorReporte{
    @Override
    public boolean exportar(Map<String, Integer> datos, String rutaDestino) throws Exception {
        try (Workbook libro = new XSSFWorkbook()) {
            Sheet hoja = libro.createSheet("Reporte Especialidades");
            
            Row filaEncabezado = hoja.createRow(0);
            filaEncabezado.createCell(0).setCellValue("Especialidad");
            filaEncabezado.createCell(1).setCellValue("Cantidad de Pacientes");
            
            int numFila = 1;
            for (Map.Entry<String, Integer> entry : datos.entrySet()) {
                Row fila = hoja.createRow(numFila++);
                fila.createCell(0).setCellValue(entry.getKey());
                fila.createCell(1).setCellValue(entry.getValue());
            }
            
            hoja.autoSizeColumn(0);
            hoja.autoSizeColumn(1);
            
            try (FileOutputStream archivoSalida = new FileOutputStream(rutaDestino)) {
                libro.write(archivoSalida);
            }
            return true;
        } catch (Exception e) {
            throw new Exception("Error al generar el archivo Excel: " + e.getMessage());
        }
    }
}
