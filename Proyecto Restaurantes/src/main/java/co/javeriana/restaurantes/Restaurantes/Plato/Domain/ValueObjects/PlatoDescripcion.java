package co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Exceptions.PlatoNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class PlatoDescripcion extends StringValueObject {

    private PlatoDescripcion() {}

    public PlatoDescripcion(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        PlatoDescripcionRestriction(value);
    }

    private void PlatoDescripcionRestriction(String value) {
        if(value.length() > 400 || value.length() < 1) {
            throw new PlatoNombreInvalido("La descripcion del plato debe ser entre 1 y 400 caracteres");
        }
    }
}
