package co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Exceptions.InsumoNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class InsumoNombre extends StringValueObject {

    private InsumoNombre() {}

    public InsumoNombre(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        insumoNombreRestriccion(value);
    }

    private void insumoNombreRestriccion(String value) {
        if(value.length() > 400 || value.length() < 1) {
            throw new InsumoNombreInvalido("El nombre del insumo debe estar entre 1 y 400 caracteres");
        }
    }
}
