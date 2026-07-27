/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author samue
 */
public class AtencionMedica {
   private int idAtencion;
    private Cita cita; 
    private String motivoConsulta; 
    private String antecedentes; 
    private String signosVitales; 
    private String diagnostico; 
    private String tratamiento; 
    private String observaciones;

    public AtencionMedica(int idAtencion, Cita cita, String motivoConsulta, String antecedentes, String signosVitales, String diagnostico, String tratamiento, String observaciones) {
        this.idAtencion = idAtencion;
        this.cita = cita;
        this.motivoConsulta = motivoConsulta;
        this.antecedentes = antecedentes;
        this.signosVitales = signosVitales;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(String signosVitales) {
        this.signosVitales = signosVitales;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "AtencionMedica{" + "idAtencion=" + idAtencion + ", cita=" + cita + ", motivoConsulta=" + motivoConsulta + ", antecedentes=" + antecedentes + ", signosVitales=" + signosVitales + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + '}';
    }
    
}
