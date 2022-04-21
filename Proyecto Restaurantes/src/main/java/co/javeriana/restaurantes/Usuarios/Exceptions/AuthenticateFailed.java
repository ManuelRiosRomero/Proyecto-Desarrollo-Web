package co.javeriana.restaurantes.Usuarios.Exceptions;

public class AuthenticateFailed extends RuntimeException{
    public AuthenticateFailed(String message) {
        super(message);
    }
}
