package co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class UbicacionPais extends StringValueObject {

    private UbicacionPais() {}

    public UbicacionPais(String value) {
        this.value = value;
    }

}
