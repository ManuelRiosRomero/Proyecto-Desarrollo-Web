package co.javeriana.restaurantes.Restaurantes.Domain.Exceptions;

public class InsumoNombreInvalido extends RuntimeException {

    public InsumoNombreInvalido(String message) {
        super(message);
    }
}
