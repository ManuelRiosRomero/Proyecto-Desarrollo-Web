package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class EmpleadoCedula extends StringValueObject {

    public EmpleadoCedula(String value) {
        this.value = value;
    }

    private EmpleadoCedula() {}
}
