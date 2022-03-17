package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Shared.Domain.Aggregate.CustomUUID;

public class EmpleadoID extends CustomUUID {

    private EmpleadoID() {}

    public EmpleadoID(String value) {
        super(value);
    }
}
