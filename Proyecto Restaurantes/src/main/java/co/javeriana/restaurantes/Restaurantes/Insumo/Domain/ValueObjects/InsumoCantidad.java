package co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.CantidadNegativa;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.IntegerValueObject;

public class InsumoCantidad extends IntegerValueObject {

    private InsumoCantidad() {}

    public InsumoCantidad(Integer value) {
        validate(value);
    }

    private void validate(Integer value) {
        validate(value);
    }

    private void cantidadNoNegativa(Integer value) {
        if (value < 0) {
            throw new CantidadNegativa("La cantidad de insumos no puede ser negativa");
        }
    }

}
