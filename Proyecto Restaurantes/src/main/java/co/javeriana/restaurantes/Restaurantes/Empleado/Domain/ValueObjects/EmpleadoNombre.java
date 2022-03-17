package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.EmpleadoNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class EmpleadoNombre extends StringValueObject {

    private EmpleadoNombre() {}

    public EmpleadoNombre(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        restriccionNombre(value);
    }

    private void restriccionNombre(String value) {
        if (value.length() > 30 || value.length() < 3) {
            throw new EmpleadoNombreInvalido("El nombre del empleado debe ser de al menos 3 caracteres y maximo 30");
        }
    }

}
