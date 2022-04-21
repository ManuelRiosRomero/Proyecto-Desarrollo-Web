package co.javeriana.restaurantes.Restaurantes.Domain.Exceptions;

public class PlatoNombreInvalido extends RuntimeException{
    public PlatoNombreInvalido(String message) {
        super(message);
    }
}
