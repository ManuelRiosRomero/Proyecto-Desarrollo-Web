package co.javeriana.restaurantes.Restaurantes.Plato.Domain.Exceptions;

public class CantidadNegativa extends RuntimeException {

    public CantidadNegativa(String message) {
        super(message);
    }
}
