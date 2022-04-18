package co.javeriana.restaurantes.Shared.Domain.Exceptions;

public class UnauthorizedAction extends RuntimeException {

    public UnauthorizedAction(String message) {
        super(message);
    }

}

