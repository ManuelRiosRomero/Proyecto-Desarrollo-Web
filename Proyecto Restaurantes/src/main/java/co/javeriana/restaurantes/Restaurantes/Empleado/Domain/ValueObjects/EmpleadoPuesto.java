package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class EmpleadoPuesto extends StringValueObject {

    private EmpleadoPuesto() {}

    public EmpleadoPuesto(String value) {
        this.value = value;
    }
}
