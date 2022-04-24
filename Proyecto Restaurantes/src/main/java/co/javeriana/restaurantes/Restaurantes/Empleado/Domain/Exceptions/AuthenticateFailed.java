package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Exceptions;

public class AuthenticateFailed extends RuntimeException {
    public AuthenticateFailed(String message) {
        super(message);
    }
}
