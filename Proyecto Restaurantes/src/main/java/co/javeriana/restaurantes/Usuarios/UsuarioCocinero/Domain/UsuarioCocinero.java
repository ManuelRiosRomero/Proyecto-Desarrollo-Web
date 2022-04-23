package co.javeriana.restaurantes.Usuarios.UsuarioCocinero.Domain;

import co.javeriana.restaurantes.Usuarios.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Usuarios.UsuarioCocinero.Domain.ValueObjects.UsuarioCocineroEmail;
import co.javeriana.restaurantes.Usuarios.UsuarioCocinero.Domain.ValueObjects.UsuarioCocineroPassword;

import java.util.HashMap;

public class UsuarioCocinero {
    private UsuarioCocineroEmail usuarioCocineroEmail;
    private UsuarioCocineroPassword usuarioCocineroPassword;

    public UsuarioCocinero(UsuarioCocineroEmail usuarioCocineroEmail, UsuarioCocineroPassword usuarioCocineroPassword) {
        this.usuarioCocineroEmail = usuarioCocineroEmail;
        this.usuarioCocineroPassword = usuarioCocineroPassword;
    }

    public static UsuarioCocinero create(UsuarioCocineroEmail usuarioCocineroEmail, UsuarioCocineroPassword usuarioCocineroPassword){
        UsuarioCocinero usuarioCocinero = new UsuarioCocinero(usuarioCocineroEmail, usuarioCocineroPassword);
        return usuarioCocinero;
    }

    //Autenticacion de Usuario Cocinero
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
