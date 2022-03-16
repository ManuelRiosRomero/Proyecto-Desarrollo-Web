package co.javeriana.restaurantes.CadenaRestaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.DateValueObject;

import java.util.Date;

public class FacturaFecha extends DateValueObject {
    public FacturaFecha(Date value) {
        //validate(value);
        this.value = value;
    }

    private void validate(Double value){
    }

}
