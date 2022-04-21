package co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.ValueObjects;


import co.javeriana.restaurantes.CadenaRestaurantes.Cadena.Domain.Exceptions.CadenaNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class CadenaNombreEmpresarial extends StringValueObject {
    private CadenaNombreEmpresarial() {}

    public CadenaNombreEmpresarial(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        restriccionNombre(value);
    }

    private void restriccionNombre(String value) {
        if (value.length() > 100 || value.length() < 1) {
            throw new CadenaNombreInvalido("El nombre empresarial debe ser entre 1 y 100 caracteres");
        }
    }
}
