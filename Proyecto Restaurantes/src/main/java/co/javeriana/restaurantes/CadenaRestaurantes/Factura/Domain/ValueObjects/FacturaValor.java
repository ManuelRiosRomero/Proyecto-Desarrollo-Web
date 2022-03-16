package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.Exceptions.ValuePositive;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.DoubleValueObject;

public class FacturaValor extends DoubleValueObject {
    public FacturaValor(Double value) {
        validate(value);
        this.value = value;
    }
    private void validate(Double value){
        valuePositive(value);
    }


    private void valuePositive(Double value){
        if(value<0||value==0){
            throw new ValuePositive(("\nEl valor de la factura no es mayor a 0"));
        }
    }

}
