package co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain;

import co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.ValueObjects.UsuarioAdminEmail;
import co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.ValueObjects.UsuarioAdminPassword;

import java.util.HashMap;

public class UsuarioAdmin {
    private UsuarioAdminEmail usuarioAdminEmail;
    private UsuarioAdminPassword usuarioAdminPassword;

    public UsuarioAdmin(UsuarioAdminEmail usuarioAdminEmail, UsuarioAdminPassword usuarioAdminPassword) {
        this.usuarioAdminEmail = usuarioAdminEmail;
        this.usuarioAdminPassword = usuarioAdminPassword;
    }

    public static UsuarioAdmin create(UsuarioAdminEmail usuarioAdminEmail, UsuarioAdminPassword usuarioAdminPassword){
        UsuarioAdmin usuarioAdmin = new UsuarioAdmin(usuarioAdminEmail, usuarioAdminPassword);
        return usuarioAdmin;
    }

    //Autenticacion de Usuario Admin
    public void authenticateUserAdmin(UsuarioAdminEmail usuarioAdminEmail, UsuarioAdminPassword usuarioAdminPassword){
        if(!(this.usuarioAdminPassword.equals(usuarioAdminPassword) && this.usuarioAdminEmail.equals(usuarioAdminEmail))){
            throw new AuthenticateFailed("Credenciales Invalidas");
        }
    }

    //HashMap
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("email", usuarioAdminEmail.value());
        }};
        return data;
    }
}
