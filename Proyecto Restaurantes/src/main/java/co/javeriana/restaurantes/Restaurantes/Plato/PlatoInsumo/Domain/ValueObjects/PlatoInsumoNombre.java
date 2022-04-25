package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects;

//import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.InsumoNombreInvalido;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class PlatoInsumoNombre extends StringValueObject {
    private PlatoInsumoNombre(){}

    public PlatoInsumoNombre(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        platoInsumoNombreRestriccion(value);
    }

    private void platoInsumoNombreRestriccion(String value) {
        if(value.length() > 400 || value.length() < 1) {
            throw new RuntimeException("El nombre del insumo debe estar entre 1 y 400 caracteres");
        }
    }
}
