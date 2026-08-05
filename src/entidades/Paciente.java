/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author samue
 */
public class Paciente extends Persona {

    private String apoderado;
    private String numeroHistoriaClinica;
    private EstadoPaciente estado;
    private String seguroMedico;

    public enum EstadoPaciente {
        ACTIVO, INACTIVO
    }

    private Paciente(Builder builder) {
        super(builder.dni, builder.nombres, builder.apellidos, builder.fechaNacimiento, builder.sexo, builder.telefono, builder.direccion);

        this.apoderado = builder.apoderado;
        this.numeroHistoriaClinica = builder.numeroHistoriaClinica;
        this.estado = builder.estado;
    }

    public String getApoderado() {
        return apoderado;
    }

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tApoderado: " + apoderado + "\n\tNumero del Historia Clinico: " + numeroHistoriaClinica;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public static class Builder {

        private String dni;
        private String nombres;
        private String apellidos;
        private LocalDate fechaNacimiento;
        private char sexo;
        private String telefono;
        private String direccion;

        private String apoderado;
        private String numeroHistoriaClinica;
        private String seguroMedico;
        private EstadoPaciente estado = EstadoPaciente.ACTIVO;

        public Builder dni(String dni) {
            this.dni = dni;
            return this;
        }

        public Builder nombres(String nombres) {
            this.nombres = nombres;
            return this;
        }

        public Builder apellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder sexo(char sexo) {
            this.sexo = sexo;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder apoderado(String apoderado) {
            this.apoderado = apoderado;
            return this;
        }

        public Builder numeroHistoriaClinica(String numeroHistoriaClinica) {
            this.numeroHistoriaClinica = numeroHistoriaClinica;
            return this;
        }

        public Builder seguroMedico(String seguroMedico) {
            this.seguroMedico = seguroMedico;
            return this;
        }

        public Builder estado(EstadoPaciente estado) {
            this.estado = estado;
            return this;
        }

        public Paciente build() {
            return new Paciente(this);
        }
    }
}
