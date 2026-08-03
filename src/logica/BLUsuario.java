package logica;

import datos.*;
import entidades.*;
import excepciones.DatosInvalidosException;
import java.security.MessageDigest;

public class BLUsuario {
    
    private static String aplicarHash(String password) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static Usuario iniciarSesion(String nombreUsuario, String contrasena) throws Exception {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || nombreUsuario.startsWith(" ")) {
            throw new DatosInvalidosException("El nombre de usuario es inválido o está vacío.");
        }
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new DatosInvalidosException("La contraseña es obligatoria.");
        }

        String contrasenaHash = aplicarHash(contrasena.trim());

        Usuario usu = DALUsuario.autenticarUsuario(nombreUsuario.trim(), contrasenaHash);
        
        if (usu == null) {
            throw new DatosInvalidosException("Credenciales incorrectas o usuario bloqueado.");
        }

        DALAuditoria.registrarAccionAuditoria(usu.getNombreUsuario(), "Seguridad", "Inicio de sesión exitoso");

        return usu;
    }

    public static boolean registrarUsuario(String dni, String nombres, String apellidos, String nombreUsuario, String contrasena, Usuario.RolUsuario rol, String usuarioAuditoria) throws Exception {

        if (dni == null || dni.trim().length() != 8 || !dni.trim().matches("\\d+")) {
            throw new DatosInvalidosException("El DNI debe tener exactamente 8 números.");
        }
        if (nombres == null || nombres.trim().isEmpty()) {
            throw new DatosInvalidosException("Los nombres son obligatorios.");
        }
        if (apellidos == null || apellidos.trim().isEmpty()) {
            throw new DatosInvalidosException("Los apellidos son obligatorios.");
        }
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || nombreUsuario.startsWith(" ")) {
            throw new DatosInvalidosException("El nombre de usuario es obligatorio.");
        }

        String passLimpio = contrasena != null ? contrasena.trim() : "";
        String regexSeguridad = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.-])[A-Za-z\\d@$!%*?&.-]{8,}$";
        if (!passLimpio.matches(regexSeguridad)) {
            throw new DatosInvalidosException("La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula, un número y un carácter especial.");
        }

        String contrasenaEncriptada = aplicarHash(passLimpio);

        Usuario usu = new Usuario(0, nombreUsuario.trim(), contrasenaEncriptada, rol, true);
        
        boolean exito = DALUsuario.registrarUsuario(usu, dni.trim(), nombres.trim(), apellidos.trim());

        if (exito) {
            DALAuditoria.registrarAccionAuditoria(usuarioAuditoria, "Gestión de Usuarios", "Creación de usuario: " + usu.getNombreUsuario());
        }

        return exito;
    }

    public static boolean bloquearUsuario(int idUsuario, String usuarioAuditoria) throws Exception {
        if (idUsuario <= 0) {
            throw new DatosInvalidosException("El ID del usuario a bloquear no es válido.");
        }
        
        boolean exito = DALUsuario.bloquearUsuario(idUsuario);
        if (!exito) {
            throw new DatosInvalidosException("No se pudo bloquear al usuario. Es posible que no exista.");
        }

        DALAuditoria.registrarAccionAuditoria(usuarioAuditoria, "Gestión de Usuarios", "Bloqueo de ID: " + idUsuario);

        return exito;
    }
}