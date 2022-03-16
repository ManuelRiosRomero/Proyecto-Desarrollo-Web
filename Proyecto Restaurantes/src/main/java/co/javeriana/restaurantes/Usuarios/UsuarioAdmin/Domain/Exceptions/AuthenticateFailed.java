package co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.Exceptions;

public class AuthenticateFailed extends RuntimeException{
    public AuthenticateFailed(String message) {
        super(message);
    }
}
