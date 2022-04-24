package co.javeriana.restaurantes.Restaurantes.Empleado.Application.Login;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Ports.EmpleadoRepository;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.EmpleadoCedula;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.EmpleadoPassword;

import java.util.Optional;

public class EmpleadoLogin {

    private EmpleadoRepository repository;

    public EmpleadoLogin(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public void execute(String cedula, String password) {
        Optional<Empleado> optionalEmpleado = repository.findByCedula(new EmpleadoCedula(cedula));
        if(optionalEmpleado.isEmpty()) {
            throw new AuthenticateFailed("No se encontro el usuario");
        }
        Empleado empleado = optionalEmpleado.get();
        empleado.authenticateEmpleado(new EmpleadoCedula(cedula), new EmpleadoPassword(password));
    }


}
