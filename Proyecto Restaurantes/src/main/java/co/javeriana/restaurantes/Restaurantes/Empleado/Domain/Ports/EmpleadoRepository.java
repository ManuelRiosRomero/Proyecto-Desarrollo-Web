package co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Ports;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.EmpleadoCedula;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.EmpleadoID;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository {

    void save(Empleado empleado);
    void update(Empleado empleado);
    Optional<Empleado> find(EmpleadoID empleadoId);
    Optional<Empleado> findByCedula(EmpleadoCedula empleadoCedula);
    Optional<List<Empleado>> all();
    void delete(Empleado empleado);

}
