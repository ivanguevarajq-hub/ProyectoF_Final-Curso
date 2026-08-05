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
public class Persona {
    protected String dni; 
    protected String nombres;
    protected String apellidos;
    protected LocalDate fechaNacimiento;
    protected char sexo; 
    protected String telefono;
    protected String direccion;
    public Persona(){}
    public Persona(String dni, String nombres, String apellidos, LocalDate fechaNacimiento, char sexo, String telefono, String direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        String sexo="Hombre";
        if (getSexo() == 'M') {
            sexo = "Mujer";
        }
        
        return "\n\tDni:" + dni + "\n\tNombres: " + nombres + "\n\tApellidos: " + apellidos + "\n\tFecha de Nacimiento: " + fechaNacimiento + "\n\tSexo: " + sexo  + "\n\tTelefono: " + telefono + "\n\tDireccion: " + direccion;
    }
    
}
