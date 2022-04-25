package co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.CantidadNegativa;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.DoubleValueObject;

public class PlatoCosto extends DoubleValueObject {

    private PlatoCosto() {}

    public PlatoCosto(Double value) {
        validate(value);
        this.value = value;
    }

    private void validate(Double value) {
        cantidadNoNegativa(value);
    }

    private void cantidadNoNegativa(Double value) {
        if (value <= 0) {
            throw new CantidadNegativa("El costo de un plato ser mayor a 0.");
        }
    }

}
