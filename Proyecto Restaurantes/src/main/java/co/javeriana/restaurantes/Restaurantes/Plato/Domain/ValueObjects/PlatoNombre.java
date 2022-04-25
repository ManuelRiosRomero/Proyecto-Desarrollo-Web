package co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Exceptions.PlatoNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class PlatoNombre extends StringValueObject {

    private PlatoNombre() {}

    public PlatoNombre(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        platoNombreRestriccion(value);
    }

    private void platoNombreRestriccion(String value) {
        if(value.length() > 50 || value.length() < 1) {
            throw new PlatoNombreInvalido("El nombre del insumo debe estar entre 1 y 50 caracteres");
        }
    }
}
