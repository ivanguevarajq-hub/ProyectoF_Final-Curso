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
public class Paciente extends Persona{
  private String apoderado; 
    private String numeroHistoriaClinica;
    private EstadoPaciente estado;  
    public enum EstadoPaciente { ACTIVO, INACTIVO }

    public Paciente(String apoderado, String numeroHistoriaClinica, EstadoPaciente estado, String dni, String nombres, String apellidos, LocalDate fechaNacimiento, char sexo, String telefono, String direccion) {
        super(dni, nombres, apellidos, fechaNacimiento, sexo, telefono, direccion);
        this.apoderado = apoderado;
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.estado = estado;
    }

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }

    public void setEstado(EstadoPaciente estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString()+ "Paciente{" + "apoderado=" + apoderado + ", numeroHistoriaClinica=" + numeroHistoriaClinica + ", estado=" + estado + '}';
    }
    
}
