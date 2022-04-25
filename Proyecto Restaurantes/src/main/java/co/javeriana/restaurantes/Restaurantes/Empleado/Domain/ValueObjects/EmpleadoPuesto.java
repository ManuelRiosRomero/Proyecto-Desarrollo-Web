package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Exceptions.NoType;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

public class EmpleadoPuesto extends StringValueObject {

    private EmpleadoPuesto() {}

    public EmpleadoPuesto(String value) {
        validate(value);
        this.value = value;
    }
    public void validate(String value){
        noType(value);
    }
    public void noType(String value){
        if(value.equals("Cajero")&&value.equals("Mesero")&&value.equals("Cocinero")){

        }
        else{
            throw new NoType("El tipo de empleado no es valido.");
        }
    }
}
