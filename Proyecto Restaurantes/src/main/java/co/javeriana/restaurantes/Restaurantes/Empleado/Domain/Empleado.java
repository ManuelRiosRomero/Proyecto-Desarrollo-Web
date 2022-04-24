package co.javeriana.restaurantes.Restaurantes.Empleado.Domain;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Exceptions.AuthenticateFailed;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.*;

import java.util.HashMap;

public class Empleado {

    private EmpleadoID id;
    private EmpleadoCedula cedula;
    private EmpleadoNombre nombre;
    private EmpleadoPuesto puesto;
    private EmpleadoPassword password;
    private RestauranteID restauranteId;
    
    public Empleado(EmpleadoID id, EmpleadoCedula cedula, EmpleadoNombre nombre, EmpleadoPuesto puesto, EmpleadoPassword password, RestauranteID restauranteId) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.puesto = puesto;
        this.password = password;
        this.restauranteId = restauranteId;
    }

    private Empleado() {}

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id.value());
            put("cedula", cedula.value());
            put("nombre", nombre.value());
            put("puesto", puesto.value());
            put("password", password.value());
            put("restauranteId", restauranteId.value());
        }};
        return data;
    }

    public static Empleado create(EmpleadoID id, EmpleadoCedula cedula, EmpleadoNombre nombre, EmpleadoPuesto puesto, EmpleadoPassword password, RestauranteID restauranteid) {
        Empleado empleado = new Empleado(id, cedula, nombre, puesto, password, restauranteid);
        return empleado;
    }

    public void authenticateEmpleado(EmpleadoCedula cedula, EmpleadoPassword password) {
        if (!(this.password.equals(password) && this.cedula.equals(cedula))) {
            throw new AuthenticateFailed("Credenciales inválidas");
        }
    }

}
