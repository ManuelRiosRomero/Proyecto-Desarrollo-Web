package co.javeriana.restaurantes.Usuarios.UsuarioMesero.Domain;

import co.javeriana.restaurantes.Usuarios.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Usuarios.UsuarioMesero.Domain.ValueObjects.UsuarioMeseroEmail;
import co.javeriana.restaurantes.Usuarios.UsuarioMesero.Domain.ValueObjects.UsuarioMeseroPassword;

import java.util.HashMap;

public class UsuarioMesero {
    private UsuarioMeseroEmail usuarioMeseroEmail;
    private UsuarioMeseroPassword usuarioMeseroPassword;

    public UsuarioMesero(UsuarioMeseroEmail usuarioMeseroEmail, UsuarioMeseroPassword usuarioMeseroPassword) {
        this.usuarioMeseroEmail = usuarioMeseroEmail;
        this.usuarioMeseroPassword = usuarioMeseroPassword;
    }

    public static UsuarioMesero create(UsuarioMeseroEmail usuarioMeseroEmail, UsuarioMeseroPassword usuarioMeseroPassword){
        UsuarioMesero usuarioMesero = new UsuarioMesero(usuarioMeseroEmail, usuarioMeseroPassword);
        return usuarioMesero;
    }

    //Autenticacion de Usuario Mesero
    public void authenticateUserAdmin(UsuarioMeseroEmail usuarioMeseroEmail, UsuarioMeseroPassword usuarioMeseroPassword){
        if(!(this.usuarioMeseroPassword.equals(usuarioMeseroPassword) && this.usuarioMeseroEmail.equals(usuarioMeseroEmail))){
            throw new AuthenticateFailed("Credenciales Invalidas");
        }
    }

    //HashMap
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("email", usuarioMeseroEmail.value());
        }};
        return data;
    }
}
