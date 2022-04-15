package co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.PlatoNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class FacturaDescripcion extends StringValueObject {

    private FacturaDescripcion() {}

    public FacturaDescripcion(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        FacturaDescripcionRestriction(value);
    }

    private void FacturaDescripcionRestriction(String value) {
        if(value.length() > 30 || value.length() < 1) {
            throw new PlatoNombreInvalido("La descripcion de la factura debe ser entre 1 y 30 caracteres");
        }
    }
}
