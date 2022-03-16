package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.Exceptions.ValueLength;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class FacturaDescripcion extends StringValueObject {


    public FacturaDescripcion(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        valueLength(value);
    }

    private void valueLength(String value){
        if(value.length() < 1 || value.length() > 30){
            throw new ValueLength("\nLongitud invalidad");
        }
    }

}
