package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.Exceptions.ValueType;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class FacturaInsumos extends StringValueObject {


    public FacturaInsumos(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        valueType(value);
    }

    private void valueType(String value){
        if(!value.equals("Trabajo")||!value.equals("Capital")||!value.equals("Tierra")){
            throw new ValueType("\nTipo de insumo no valido (Case Sensitive)");
        }
    }

}
