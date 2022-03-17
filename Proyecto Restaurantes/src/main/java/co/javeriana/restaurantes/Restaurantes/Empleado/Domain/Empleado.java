package co.javeriana.restaurantes.Restaurantes.Empleado.Domain;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.ValueObjects.*;

import java.util.HashMap;

public class Empleado {

    private EmpleadoID id;
    private EmpleadoFechaIngreso fechaIngreso;
    private EmpleadoNombre nombre;
    private EmpleadoPuesto puesto;
    private EmpleadoSalario salario;

    public Empleado(EmpleadoID id, EmpleadoFechaIngreso fechaIngreso, EmpleadoNombre nombre, EmpleadoPuesto puesto, EmpleadoSalario salario) {
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    private Empleado() {}

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("fechaIngreso", fechaIngreso);
            put("nombre", nombre);
            put("puesto", puesto);
            put("salario", salario);
        }};
        return data;
    }

}
