package co.javeriana.restaurantes.Usuarios.Exceptions;

public class PasswordInvalida extends RuntimeException{
    public PasswordInvalida(String message) {
        super(message);
    }
}
