package co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class UbicacionPais extends StringValueObject {

    private UbicacionPais() {}

    public UbicacionPais(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        //restriccionNombre(value);
    }
/*
    private void restriccionNombre(String value) {
        if (value.length() > 30 || value.length() < 3) {
            throw new EmpleadoNombreInvalido("El nombre del empleado debe ser de al menos 3 caracteres y maximo 30");
        }
    }
 */

}
