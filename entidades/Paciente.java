/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samue
 */
public class Paciente extends Persona {
   private String apoderado; 
   private String numeroHistoriaClinica; 
    private EstadoPaciente estado; 

    public enum EstadoPaciente { ACTIVO, INACTIVO }

    public Paciente() {}

    public String getApoderado() { return apoderado; }
    public void setApoderado(String apoderado) { this.apoderado = apoderado; }

    public String getNumeroHistoriaClinica() { return numeroHistoriaClinica; }
    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) { this.numeroHistoriaClinica = numeroHistoriaClinica; }

    public EstadoPaciente getEstado() { return estado; }
    public void setEstado(EstadoPaciente estado) { this.estado = estado; }
} 

