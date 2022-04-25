package co.javeriana.restaurantes.Restaurantes.Factura.Domain.Exceptions;

public class CantidadNegativa extends RuntimeException {

    public CantidadNegativa(String message) {
        super(message);
    }
}
