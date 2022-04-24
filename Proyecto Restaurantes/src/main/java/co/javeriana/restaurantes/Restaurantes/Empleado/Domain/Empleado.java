package co.javeriana.restaurantes.Restaurantes.Empleado.Domain;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.*;

import java.util.HashMap;

public class Empleado {

    private EmpleadoID cedula;
    private EmpleadoNombre nombre;
    private EmpleadoPuesto puesto;
    private EmpleadoPassword password;
    private RestauranteID restauranteId;
    
    public Empleado(EmpleadoID id, EmpleadoNombre nombre, EmpleadoPuesto puesto, EmpleadoPassword password, RestauranteID restauranteId) {
        this.cedula = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.password = password;
        this.restauranteId = restauranteId;
    }

    private Empleado() {}

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("cedula", cedula.value());
            put("nombre", nombre.value());
            put("puesto", puesto.value());
            put("password", password.value());
            put("restauranteId", restauranteId.value());
        }};
        return data;
    }

}
