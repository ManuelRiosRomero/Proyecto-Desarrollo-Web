package co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Exceptions.FechaIngresoInvalida;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.StringValueObject;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class FacturaFecha extends StringValueObject {
    private FacturaFecha() {}

    public FacturaFecha(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validarFecha(value);
    }

    private void validarFecha(String value) {
        try {
            String[] ymd = value.split("-");
            if (ymd.length != 3) {
                throw new DateTimeException("");
            }
            LocalDateTime.of(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2]), 0, 0);
        }
        catch (DateTimeException e) {
            throw new FechaIngresoInvalida("Los valores de la fecha deben ser consistentes con el calendario");
        }
        catch (Exception e) {
            throw new FechaIngresoInvalida("Error al leer la fecha");
        }
    }

}
