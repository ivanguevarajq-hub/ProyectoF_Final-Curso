/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author samue
 */
public class ExamenLaboratorio {
    private int idExamen;
    private AtencionMedica ordenMedica; 
    private String tipoExamen;
    private String resultado; 
    private EstadoExamen estado; 

    public enum EstadoExamen { PENDIENTE, EN_PROCESO, FINALIZADO, ENTREGADO }

    public ExamenLaboratorio(int idExamen, AtencionMedica ordenMedica, String tipoExamen, String resultado, EstadoExamen estado) {
        this.idExamen = idExamen;
        this.ordenMedica = ordenMedica;
        this.tipoExamen = tipoExamen;
        this.resultado = resultado;
        this.estado = estado;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public AtencionMedica getOrdenMedica() {
        return ordenMedica;
    }

    public void setOrdenMedica(AtencionMedica ordenMedica) {
        this.ordenMedica = ordenMedica;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public EstadoExamen getEstado() {
        return estado;
    }

    public void setEstado(EstadoExamen estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ExamenLaboratorio{" + "idExamen=" + idExamen + ", ordenMedica=" + ordenMedica + ", tipoExamen=" + tipoExamen + ", resultado=" + resultado + ", estado=" + estado + '}';
    }
    
}

