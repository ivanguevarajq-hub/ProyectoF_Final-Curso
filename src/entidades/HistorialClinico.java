/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */
public class HistorialClinico {
    private final String numeroHistoria;
    private final Paciente paciente;
    private final List<AtencionMedica> atenciones;
    private final LocalDate fechaEmision;

    private HistorialClinico(Builder builder) {
        this.numeroHistoria = builder.numeroHistoria;
        this.paciente = builder.paciente;
        this.atenciones = builder.atenciones;
        this.fechaEmision = builder.fechaEmision;
    }

    public String getNumeroHistoria() { return numeroHistoria; }
    public Paciente getPaciente() { return paciente; }
    public List<AtencionMedica> getAtenciones() { return atenciones; }
    public LocalDate getFechaEmision() { return fechaEmision; }

    @Override
    public String toString() {
        return "HistorialClinico{" + "numeroHistoria=" + numeroHistoria + ", paciente=" + paciente.getNombres() + ", totalAtenciones=" + atenciones.size() + ", fechaEmision=" + fechaEmision + '}';
    }

    public static class Builder {
        private String numeroHistoria;
        private Paciente paciente;
        private List<AtencionMedica> atenciones = new ArrayList<>();
        private LocalDate fechaEmision = LocalDate.now();

        public Builder numeroHistoria(String numeroHistoria) {
            this.numeroHistoria = numeroHistoria;
            return this;
        }

        public Builder paciente(Paciente paciente) {
            this.paciente = paciente;
            return this;
        }

        public Builder atenciones(List<AtencionMedica> atenciones) {
            this.atenciones = atenciones;
            return this;
        }
        
        public Builder fechaEmision(LocalDate fechaEmision) {
            this.fechaEmision = fechaEmision;
            return this;
        }

        public HistorialClinico build() {
            return new HistorialClinico(this);
        }
    }
}
