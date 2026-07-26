/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author samue
 */
public class DetalleReceta {
    private Medicamento medicamento; 
    private int cantidad;
    private String indicaciones;

    public DetalleReceta(Medicamento medicamento, int cantidad, String indicaciones) {
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.indicaciones = indicaciones;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DetalleReceta{");
        sb.append("medicamento=").append(medicamento);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", indicaciones=").append(indicaciones);
        sb.append('}');
        return sb.toString();
    }
    
}
