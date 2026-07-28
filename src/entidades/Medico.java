/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import java.time.*;

/**
 *
 * @author samue
 */
public class Medico extends Persona{
    private String numeroColegiatura; 
    private String especialidad; 
    private boolean activo;
    public Medico(){
        super();
    }
public Medico(String dni, String nombres, String apellidos, LocalDate fechaNacimiento, char sexo, String telefono, String direccion, String numeroColegiatura, String especialidad, boolean activo) {
        super(dni, nombres, apellidos, fechaNacimiento, sexo, telefono, direccion); 
        this.numeroColegiatura = numeroColegiatura;
        this.especialidad = especialidad;
        this.activo = activo;
    }
    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return super.toString() + "Medico{" + "numeroColegiatura=" + numeroColegiatura + ", especialidad=" + especialidad + ", activo=" + activo + '}';
    }

    
}
