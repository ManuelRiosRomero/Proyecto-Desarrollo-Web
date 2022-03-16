package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.Exceptions;

public class ValuePositive extends RuntimeException{
    public ValuePositive(String message) {
        super(message);
    }
}
