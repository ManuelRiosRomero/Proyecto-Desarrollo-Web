package co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class RestauranteID extends CustomUUID {

    private RestauranteID() {}

    public RestauranteID(String value) {
        super(value);
    }
}
