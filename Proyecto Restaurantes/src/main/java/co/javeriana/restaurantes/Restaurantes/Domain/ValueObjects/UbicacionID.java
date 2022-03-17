package co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class UbicacionID extends CustomUUID {

    private UbicacionID() {}

    public UbicacionID(String value) {
        super(value);
    }
}
