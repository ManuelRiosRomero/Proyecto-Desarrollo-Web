package co.javeriana.restaurantes.Usuarios.UsuarioMesero.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;
import co.javeriana.restaurantes.Usuarios.Exceptions.PasswordInvalida;

public class UsuarioMeseroPassword extends StringValueObject {
    public UsuarioMeseroPassword(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        passwordInvalida(value);
    }

    private void passwordInvalida(String value){
        if(value.length() < 8){
            throw new PasswordInvalida("La contraseña es demasiado corta: Minimo 8 caracteres");
        }
    }
}
