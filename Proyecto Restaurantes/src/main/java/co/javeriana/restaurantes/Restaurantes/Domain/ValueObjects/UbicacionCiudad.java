package co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class UbicacionCiudad extends StringValueObject {

    private UbicacionCiudad() {}

    public UbicacionCiudad(String value) {
        this.value = value;
    }

}
