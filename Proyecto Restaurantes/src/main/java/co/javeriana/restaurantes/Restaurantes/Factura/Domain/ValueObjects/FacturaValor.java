package co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Exceptions.CantidadNegativa;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.DoubleValueObject;

public class FacturaValor extends DoubleValueObject {
    private FacturaValor() {}

    public FacturaValor(Double value) {
        validate(value);
        this.value = value;
    }

    private void validate(Double value) {
        cantidadNoNegativa(value);
    }

    private void cantidadNoNegativa(Double value) {
        if (value <= 0) {
            throw new CantidadNegativa("El valor de una factura debe ser mayor a 0.");
        }
    }

}
