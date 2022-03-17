package co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class UbicacionDireccion extends StringValueObject {

    private UbicacionDireccion() {}

    public UbicacionDireccion(String value) {
        this.value = value;
    }
}
