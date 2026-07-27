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
public class Usuario extends Persona{
    private int idUsuario;
    private String nombreUsuario; 
    private String contrasena;
    private RolUsuario rol; 
    private boolean activo;
    public enum RolUsuario {
        ADMINISTRADOR, RECEPCIONISTA, MEDICO, ENFERMERA, 
        LABORATORISTA, FARMACEUTICO, CAJERO, DIRECTOR_MEDICO
    }

    public Usuario(int idUsuario, String nombreUsuario, String contrasena, RolUsuario rol, boolean activo, String dni, String nombres, String apellidos, LocalDate fechaNacimiento, char sexo, String telefono, String direccion) {
        super(dni, nombres, apellidos, fechaNacimiento, sexo, telefono, direccion);
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return super.toString()+ "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", rol=" + rol + ", activo=" + activo + '}';
    }
    
}
