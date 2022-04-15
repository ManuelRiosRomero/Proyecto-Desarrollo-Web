package co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.CantidadNegativa;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.DoubleValueObject;

public class InsumoCosto extends DoubleValueObject {

    private InsumoCosto() {}

    public InsumoCosto(Double value) {
        validate(value);
    }

    private void validate(Double value) {
        cantidadNoNegativa(value);
    }

    private void cantidadNoNegativa(Double value) {
        if (value <= 0) {
            throw new CantidadNegativa("El costo de un insumo debe ser mayor a 0.");
        }
    }

}
