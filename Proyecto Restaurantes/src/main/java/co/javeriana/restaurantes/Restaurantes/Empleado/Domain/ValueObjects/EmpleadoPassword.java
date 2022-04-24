package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class EmpleadoPassword extends StringValueObject {

    private EmpleadoPassword() {}

    public EmpleadoPassword(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        restriccionPassword(value);
    }

    private void restriccionPassword(String value) {
    }

}
