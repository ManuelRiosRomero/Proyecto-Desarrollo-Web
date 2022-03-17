package co.javeriana.restaurantes.Restaurantes.Domain.Exceptions;

public class FechaIngresoInvalida extends RuntimeException{

    public FechaIngresoInvalida(String message) {
        super(message);
    }
}
