package co.javeriana.restaurantes.Usuarios.UsuarioAdmin.Domain.Exceptions;

public class EmailFormat extends RuntimeException{
    public EmailFormat(String message) {
        super(message);
    }
}
