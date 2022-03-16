package co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.Exceptions;

public class PasswordInvalida extends RuntimeException{
    public PasswordInvalida(String message) {
        super(message);
    }
}
