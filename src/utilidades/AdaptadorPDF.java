/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Map;
/**
 *
 * @author samue
 */
public class AdaptadorPDF  implements IExportadorReporte{
    
    @Override
    public boolean exportar(Map<String, Integer> datos, String rutaDestino) throws Exception {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(rutaDestino));
            documento.open();
            documento.add(new Paragraph("Reporte de Atenciones por Especialidad\n\n"));
            
            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("Especialidad");
            tabla.addCell("Cantidad de Pacientes");
            
            for (Map.Entry<String, Integer> entry : datos.entrySet()) {
                tabla.addCell(entry.getKey());
                tabla.addCell(String.valueOf(entry.getValue()));
            }
            
            documento.add(tabla);
            documento.close();
            return true;
        } catch (Exception e) {
            throw new Exception("Error al generar el archivo PDF: " + e.getMessage());
        }
    }
}

