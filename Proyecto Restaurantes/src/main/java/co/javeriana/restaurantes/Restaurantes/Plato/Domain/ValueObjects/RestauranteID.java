package co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class RestauranteID extends CustomUUID {

    public RestauranteID(String value) {
        super(value);
    }

    private RestauranteID() {}

}
