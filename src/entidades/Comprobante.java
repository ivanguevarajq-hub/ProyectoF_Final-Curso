/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import java.time.LocalDateTime;
/**
 *
 * @author samue
 */
public class Comprobante {
    private String numeroComprobante; 
    private AtencionMedica atencionMedica; 
    private double montoTotal;
    private MetodoPago metodoPago;
    private LocalDateTime fechaHora;

    public enum MetodoPago { EFECTIVO, TARJETA, TRANSFERENCIA, BILLETERA_ELECTRONICA }

    public Comprobante(String numeroComprobante, AtencionMedica atencionMedica, double montoTotal, MetodoPago metodoPago, LocalDateTime fechaHora) {
        this.numeroComprobante = numeroComprobante;
        this.atencionMedica = atencionMedica;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.fechaHora = fechaHora;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public AtencionMedica getAtencionMedica() {
        return atencionMedica;
    }

    public void setAtencionMedica(AtencionMedica atencionMedica) {
        this.atencionMedica = atencionMedica;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
}
