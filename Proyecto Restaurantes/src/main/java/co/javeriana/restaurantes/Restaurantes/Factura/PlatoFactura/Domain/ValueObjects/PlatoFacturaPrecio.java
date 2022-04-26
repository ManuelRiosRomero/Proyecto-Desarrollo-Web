package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.DoubleValueObject;

public class PlatoFacturaPrecio extends DoubleValueObject {

    private PlatoFacturaPrecio() {
    }

    public PlatoFacturaPrecio(double value) {

        this.value = value;
    }
}
