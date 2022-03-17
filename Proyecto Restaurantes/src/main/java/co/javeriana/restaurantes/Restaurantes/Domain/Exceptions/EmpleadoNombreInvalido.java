package co.javeriana.restaurantes.Restaurantes.Domain.Exceptions;

public class EmpleadoNombreInvalido extends RuntimeException{

    public EmpleadoNombreInvalido(String message) {
        super(message);
    }
}
