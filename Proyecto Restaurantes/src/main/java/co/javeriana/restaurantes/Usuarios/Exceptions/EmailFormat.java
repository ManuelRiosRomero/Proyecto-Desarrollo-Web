package co.javeriana.restaurantes.Usuarios.Exceptions;

public class EmailFormat extends RuntimeException{
    public EmailFormat(String message) {
        super(message);
    }
}
