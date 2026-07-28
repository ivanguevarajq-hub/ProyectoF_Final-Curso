/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.DALUsuario;
import entidades.Usuario;
import excepciones.DatosInvalidosException;
import java.time.LocalDate;

/**
 *
 * @author samue
 */
public class BLUsuario {

    public static Usuario iniciarSesion(String nombreUsuario, String contrasena) throws Exception {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || nombreUsuario.startsWith(" ")) {
            throw new DatosInvalidosException("El nombre de usuario es inválido o está vacío.");
        }
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new DatosInvalidosException("La contraseña es obligatoria.");
        }

        DALUsuario dal = new DALUsuario();
        Usuario usu = dal.autenticarUsuario(nombreUsuario.trim(), contrasena.trim());
        
        if (usu == null) {
            throw new DatosInvalidosException("Credenciales incorrectas o usuario bloqueado.");
        }
        return usu;
    }

    public static boolean registrarUsuario(String dni, String nombres, String apellidos, LocalDate fechaNacimiento, char sexo, String telefono, String direccion, String nombreUsuario, String contrasena, Usuario.RolUsuario rol) throws Exception {

        if (dni == null || dni.trim().length() != 8 || !dni.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El DNI debe tener exactamente 8 números.");
        }
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || nombreUsuario.startsWith(" ")) {
            throw new DatosInvalidosException("El nombre de usuario es obligatorio.");
        }

        String passLimpio = contrasena != null ? contrasena.trim() : "";
        String regexSeguridad = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.-])[A-Za-z\\d@$!%*?&.-]{8,}$";
        if (!passLimpio.matches(regexSeguridad)) {
            throw new DatosInvalidosException("La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula, un número y un carácter especial.");
        }

       Usuario usu = new Usuario(
            0,                           
            nombreUsuario.trim(),        
            passLimpio,                    
            rol,                           
            true,                          
            dni.trim(),                   
            nombres.trim(),                
            apellidos.trim(),            
            fechaNacimiento,               
            sexo,                          
            telefono.trim(),               
            direccion.trim()               
        );

        DALUsuario dal = new DALUsuario();
        return dal.registrarUsuario(usu);
    }

    public static boolean bloquearUsuario(int idUsuario) throws Exception {
        if (idUsuario <= 0) {
            throw new DatosInvalidosException("El ID del usuario a bloquear no es válido.");
        }
        
        DALUsuario dal = new DALUsuario();
        boolean exito = dal.bloquearUsuario(idUsuario);
        if (!exito) {
            throw new DatosInvalidosException("No se pudo bloquear al usuario. Es posible que no exista.");
        }
        return exito;
    }
}
