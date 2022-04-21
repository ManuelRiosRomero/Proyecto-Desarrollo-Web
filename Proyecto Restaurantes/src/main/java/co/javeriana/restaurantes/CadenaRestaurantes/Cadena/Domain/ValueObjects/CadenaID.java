package co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class CadenaID extends CustomUUID {

    private CadenaID() {}

    public CadenaID(String value) {
        super(value);
    }
}