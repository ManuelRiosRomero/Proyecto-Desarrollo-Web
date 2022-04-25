package co.javeriana.restaurantes.Restaurantes.Factura.Domain.Exceptions;

public class FechaIngresoInvalida extends RuntimeException{

    public FechaIngresoInvalida(String message) {
        super(message);
    }
}
