package co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.ValueObjects;

import co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.Exceptions.CadenaNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.IntegerValueObject;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class CadenaNumeroContacto extends StringValueObject {
    private CadenaNumeroContacto() {}

    public CadenaNumeroContacto(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        restriccionNumero(value);
    }

    private void restriccionNumero(String value) {
        if (value.length() > 10 || value.length() < 10) {
            throw new CadenaNombreInvalido("El numero empresarial debe ser de 10 digitos.");
        }
    }
}
