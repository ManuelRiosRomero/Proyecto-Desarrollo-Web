package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.FechaIngresoInvalida;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.DateTimeValueObject;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class EmpleadoFechaIngreso extends DateTimeValueObject{

    private EmpleadoFechaIngreso() {}

    public EmpleadoFechaIngreso(int year, int month, int day) {
        validate(year, month, day);
        this.dateTime = LocalDateTime.of(year, month, day, 0, 0, 0);
    }

    private void validate(int year, int month, int day) {
        validarFecha(year, month, day);
    }

    private void validarFecha(int year, int month, int day) {
        try {
            LocalDateTime.of(year, month, day, 0, 0, 0);
        }
        catch (DateTimeException e) {
            throw new FechaIngresoInvalida("Los valores de la fecha deben ser consistentes con el calendario");
        }
    }

}
