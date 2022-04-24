package co.javeriana.restaurantes.Restaurantes.Empleado.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Ports.EmpleadoRepository;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.*;

public class EmpleadoCreator {

    private EmpleadoRepository repository;

    public EmpleadoCreator(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String cedula, String nombre, String puesto, String password, String restauranteId) {
        Empleado empleado = Empleado.create(new EmpleadoID(id), new EmpleadoCedula(cedula), new EmpleadoNombre(nombre),
                new EmpleadoPuesto(puesto), new EmpleadoPassword(password),
                new RestauranteID(id));
        repository.save(empleado);
    }
}
