package co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.BooleanValueObject;

public class FacturaCompletado extends BooleanValueObject {
    private FacturaCompletado() {}

    public FacturaCompletado(Boolean value) {
        this.value = value;
    }
}
