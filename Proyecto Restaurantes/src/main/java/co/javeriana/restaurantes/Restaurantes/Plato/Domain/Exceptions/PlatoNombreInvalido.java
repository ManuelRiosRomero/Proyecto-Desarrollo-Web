package co.javeriana.restaurantes.Restaurantes.Plato.Domain.Exceptions;

public class PlatoNombreInvalido extends RuntimeException{
    public PlatoNombreInvalido(String message) {
        super(message);
    }
}
