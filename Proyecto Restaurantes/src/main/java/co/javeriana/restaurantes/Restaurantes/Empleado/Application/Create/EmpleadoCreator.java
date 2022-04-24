package co.javeriana.restaurantes.Restaurantes.Empleado.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Ports.EmpleadoRepository;

public class EmpleadoCreator {

    private EmpleadoRepository repository;

    public EmpleadoCreator(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public void execute(String cedula, String nombre, String puesto, String password, String restauranteId) {

    }
}
