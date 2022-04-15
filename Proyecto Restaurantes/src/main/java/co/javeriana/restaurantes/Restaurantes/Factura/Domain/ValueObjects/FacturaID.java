package co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class FacturaID extends CustomUUID {
    private FacturaID() {}

    public FacturaID(String value) {
        super(value);
    }
}
