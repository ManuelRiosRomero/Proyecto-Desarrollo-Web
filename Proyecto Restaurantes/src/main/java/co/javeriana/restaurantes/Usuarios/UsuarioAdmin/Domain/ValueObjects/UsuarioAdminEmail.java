package co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;
import co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.Exceptions.EmailFormat;

public class UsuarioAdminEmail extends StringValueObject {
    public UsuarioAdminEmail(String value) {
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
