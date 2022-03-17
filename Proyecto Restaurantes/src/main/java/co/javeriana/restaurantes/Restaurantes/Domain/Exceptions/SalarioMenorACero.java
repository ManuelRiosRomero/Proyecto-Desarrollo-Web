package co.javeriana.restaurantes.Restaurantes.Domain.Exceptions;

public class SalarioMenorACero extends RuntimeException {

    public SalarioMenorACero(String message) {
        super(message);
    }
}
