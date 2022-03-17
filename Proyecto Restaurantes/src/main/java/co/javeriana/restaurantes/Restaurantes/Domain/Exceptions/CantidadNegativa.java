package co.javeriana.restaurantes.Restaurantes.Domain.Exceptions;

public class CantidadNegativa extends RuntimeException {

    public CantidadNegativa(String message) {
        super(message);
    }
}
