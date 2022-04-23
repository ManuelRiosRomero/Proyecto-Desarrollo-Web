package co.javeriana.restaurantes.Usuarios.UsuarioMesero.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;
import co.javeriana.restaurantes.Usuarios.Exceptions.EmailFormat;

public class UsuarioMeseroEmail extends StringValueObject {
    public UsuarioMeseroEmail(String value) {
        validate(value);
        this.value = value;
    }
    private void validate(String value){
        emailFormat(value);
    }
    private void emailFormat(String value){
        if (!value.contains("@")) {
            throw new EmailFormat("Email sin @");
        }
    }
}
