package co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.CantidadNegativa;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.DoubleValueObject;

public class FacturaPropina extends DoubleValueObject {
    private FacturaPropina() {}

    public FacturaPropina(Double value) {
        validate(value);
    }

    private void validate(Double value) {
        cantidadNoNegativa(value);
    }

    private void cantidadNoNegativa(Double value) {
        if (value <= 0) {
            throw new CantidadNegativa("El valor de una propina debe ser mayor a 0.");
        }
    }

}
