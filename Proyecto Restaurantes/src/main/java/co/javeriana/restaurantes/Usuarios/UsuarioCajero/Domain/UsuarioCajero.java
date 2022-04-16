package co.javeriana.restaurantes.Usuarios.UsuarioCajero.Domain;

import co.javeriana.restaurantes.Usuarios.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Usuarios.UsuarioCajero.Domain.ValueObjects.UsuarioCajeroEmail;
import co.javeriana.restaurantes.Usuarios.UsuarioCajero.Domain.ValueObjects.UsuarioCajeroPassword;

import java.util.HashMap;

public class UsuarioCajero {
    private UsuarioCajeroEmail usuarioCajeroEmail;
    private UsuarioCajeroPassword usuarioCajeroPassword;

    public UsuarioCajero(UsuarioCajeroEmail usuarioCajeroEmail, UsuarioCajeroPassword usuarioCajeroPassword) {
        this.usuarioCajeroEmail = usuarioCajeroEmail;
        this.usuarioCajeroPassword = usuarioCajeroPassword;
    }

    public static UsuarioCajero create(UsuarioCajeroEmail usuarioCajeroEmail, UsuarioCajeroPassword usuarioCajeroPassword){
        UsuarioCajero usuarioCajero = new UsuarioCajero(usuarioCajeroEmail, usuarioCajeroPassword);
        return usuarioCajero;
    }

    //Autenticacion de Usuario Cajero
    public void authenticateUserAdmin(UsuarioCajeroEmail usuarioCajeroEmail, UsuarioCajeroPassword usuarioCajeroPassword){
        if(!(this.usuarioCajeroPassword.equals(usuarioCajeroPassword) && this.usuarioCajeroEmail.equals(usuarioCajeroEmail))){
            throw new AuthenticateFailed("Credenciales Invalidas");
        }
    }

    //HashMap
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("email", usuarioCajeroEmail.value());
        }};
        return data;
    }
}
