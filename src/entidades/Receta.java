/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import java.util.List;
/**
 *
 * @author samue
 */
public class Receta {
    private int idReceta;
    private AtencionMedica atencionMedica; 
    private List<DetalleReceta> detalles;

    public Receta(int idReceta, AtencionMedica atencionMedica, List<DetalleReceta> detalles) {
        this.idReceta = idReceta;
        this.atencionMedica = atencionMedica;
        this.detalles = detalles;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public AtencionMedica getAtencionMedica() {
        return atencionMedica;
    }

    public void setAtencionMedica(AtencionMedica atencionMedica) {
        this.atencionMedica = atencionMedica;
    }

    public List<DetalleReceta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleReceta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Receta{" + "idReceta=" + idReceta + ", atencionMedica=" + atencionMedica + ", detalles=" + detalles + '}';
    }
    
}
