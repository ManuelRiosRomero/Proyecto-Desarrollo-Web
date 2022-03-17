package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class FacturaRestauranteID extends CustomUUID {

    private FacturaRestauranteID() {}

    public FacturaRestauranteID(String value) {
        super(value);
    }
}
