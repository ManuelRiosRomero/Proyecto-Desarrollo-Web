package co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain;

import co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.ValueObjects.UsuarioCocineroEmail;
import co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.ValueObjects.UsuarioCocineroPassword;

import java.util.HashMap;

public class UsuarioCocinero {
    private UsuarioCocineroEmail usuarioCocineroEmail;
    private UsuarioCocineroPassword usuarioCocineroPassword;

    public UsuarioCocinero(UsuarioCocineroEmail usuarioCocineroEmail, UsuarioCocineroPassword usuarioCocineroPassword) {
        this.usuarioCocineroEmail = usuarioCocineroEmail;
        this.usuarioCocineroPassword = usuarioCocineroPassword;
    }

    public static UsuarioCocinero create(UsuarioCocineroEmail usuarioCocineroEmail, UsuarioCocineroPassword usuarioCocineroPassword){
        UsuarioCocinero usuarioAdmin = new UsuarioCocinero(usuarioCocineroEmail, usuarioCocineroPassword);
        return usuarioAdmin;
    }

    //Autenticacion de Usuario Admin
    public void authenticateUserAdmin(UsuarioCocineroEmail usuarioCocineroEmail, UsuarioCocineroPassword usuarioCocineroPassword){
        if(!(this.usuarioCocineroPassword.equals(usuarioCocineroPassword) && this.usuarioCocineroEmail.equals(usuarioCocineroEmail))){
            throw new AuthenticateFailed("Credenciales Invalidas");
        }
    }

    //HashMap
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("email", usuarioCocineroEmail.value());
        }};
        return data;
    }
}
