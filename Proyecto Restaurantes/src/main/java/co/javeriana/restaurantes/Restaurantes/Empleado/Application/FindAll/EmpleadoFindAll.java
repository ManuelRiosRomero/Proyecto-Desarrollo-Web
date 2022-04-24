package co.javeriana.restaurantes.Restaurantes.Empleado.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Ports.EmpleadoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoFindAll {
    private EmpleadoRepository repository;

    public EmpleadoFindAll(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> execute() {
        List<Empleado> empleados = new ArrayList<>();
        Optional<List<Empleado>> optionalEmpleados = repository.all();
        if(optionalEmpleados.isPresent()){
            empleados = optionalEmpleados.get();
        }
        return empleados;
    }

}
