package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects;

import co.javeriana.restaurantes.Restaurantes.Domain.Exceptions.SalarioMenorACero;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.IntegerValueObject;

public class EmpleadoSalario extends IntegerValueObject {

    private EmpleadoSalario() {}

    public EmpleadoSalario(Integer salario) {
        validate(salario);
        this.value = salario;
    }

    public void validate(Integer salario) {
        menorACero(salario);
    }

    public void menorACero(Integer salario) {
        if (salario < 0) {
            throw new SalarioMenorACero("El salario de los empleados no puede ser negativo");
        }
    }

}
