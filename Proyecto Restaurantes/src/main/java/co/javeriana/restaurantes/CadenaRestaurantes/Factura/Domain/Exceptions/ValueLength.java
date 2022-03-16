package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.Exceptions;

public class ValueLength extends RuntimeException{
    public ValueLength(String message) {
        super(message);
    }
}
