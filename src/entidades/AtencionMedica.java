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
    private final int idAtencion;
    private final Cita cita; 
    private final String motivoConsulta; 
    private final String antecedentes; 
    private final String signosVitales; 
    private final String diagnostico; 
    private final String tratamiento; 
    private final String observaciones;

    private AtencionMedica(Builder builder) {
        this.idAtencion = builder.idAtencion;
        this.cita = builder.cita;
        this.motivoConsulta = builder.motivoConsulta;
        this.antecedentes = builder.antecedentes;
        this.signosVitales = builder.signosVitales;
        this.diagnostico = builder.diagnostico;
        this.tratamiento = builder.tratamiento;
        this.observaciones = builder.observaciones;
    }

    public int getIdAtencion() { return idAtencion; }
    public Cita getCita() { return cita; }
    public String getMotivoConsulta() { return motivoConsulta; }
    public String getAntecedentes() { return antecedentes; }
    public String getSignosVitales() { return signosVitales; }
    public String getDiagnostico() { return diagnostico; }
    public String getTratamiento() { return tratamiento; }
    public String getObservaciones() { return observaciones; }

    @Override
    public String toString() {
        return "AtencionMedica{" + "idAtencion=" + idAtencion + ", cita=" + cita + ", motivoConsulta=" + motivoConsulta + ", antecedentes=" + antecedentes + ", signosVitales=" + signosVitales + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", observaciones=" + observaciones + '}';
    }

    public static class Builder {
        private int idAtencion;
        private Cita cita;
        private String motivoConsulta;
        private String antecedentes = "";
        private String signosVitales = "";
        private String diagnostico;
        private String tratamiento = "";
        private String observaciones = "";

        public Builder idAtencion(int idAtencion) { this.idAtencion = idAtencion; return this; }
        public Builder cita(Cita cita) { this.cita = cita; return this; }
        public Builder motivoConsulta(String motivoConsulta) { this.motivoConsulta = motivoConsulta; return this; }
        public Builder antecedentes(String antecedentes) { this.antecedentes = antecedentes; return this; }
        public Builder signosVitales(String signosVitales) { this.signosVitales = signosVitales; return this; }
        public Builder diagnostico(String diagnostico) { this.diagnostico = diagnostico; return this; }
        public Builder tratamiento(String tratamiento) { this.tratamiento = tratamiento; return this; }
        public Builder observaciones(String observaciones) { this.observaciones = observaciones; return this; }

        public AtencionMedica build() {
            return new AtencionMedica(this);
        }
    }
}