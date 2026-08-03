package entidades;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario; 
    private String contrasena;
    private RolUsuario rol; 
    private boolean activo;
    
    public enum RolUsuario {
        ADMINISTRADOR, RECEPCIONISTA, MEDICO, ENFERMERA, 
        LABORATORISTA, FARMACEUTICO, CAJERO, DIRECTOR_MEDICO
    }
    
    public Usuario() {
    }
    
    public Usuario(int idUsuario, String nombreUsuario, String contrasena, RolUsuario rol, boolean activo) {
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
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", rol=" + rol + ", activo=" + activo + '}';
    }
}