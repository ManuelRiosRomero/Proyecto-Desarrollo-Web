package co.javeriana.restaurantes.Restaurantes.Domain;

import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Domain.Entities.Ubicacion;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.RestauranteID;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SedeRestaurante {

    private RestauranteID id;
    private Ubicacion ubicacion;
    private Optional<List<Empleado>> empleados;
    private Optional<List<Insumo>> insumos;
    private Optional<List<Plato>> platos;

    public SedeRestaurante(RestauranteID id, Ubicacion ubicacion, Optional<List<Empleado>> empleados, Optional<List<Insumo>> insumos, Optional<List<Plato>> platos) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.empleados = empleados;
        this.insumos = insumos;
        this.platos = platos;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("ubicacion", ubicacion);
            put("empleados", createEmpleados());
            put("isumos", createInsumos());
            put("platos", createPlatos());
        }};
        return data;
    }

    private List<HashMap<String, Object>> createEmpleados() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!empleados.isEmpty()) {
            list = empleados.get().stream().map(empleado -> empleado.data()).collect(Collectors.toList());
        }
        return list;
    }

    private List<HashMap<String, Object>> createInsumos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!insumos.isEmpty()) {
            list = insumos.get().stream().map(insumo -> insumo.data()).collect(Collectors.toList());
        }
        return list;
    }

    private List<HashMap<String, Object>> createPlatos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!platos.isEmpty()) {
            list = platos.get().stream().map(plato -> plato.data()).collect(Collectors.toList());
        }
        return list;
    }

    public SedeRestaurante create(RestauranteID id, Ubicacion ubicacion) {
        SedeRestaurante sedeRestaurante = new SedeRestaurante(id, ubicacion, Optional.empty(), Optional.empty(),Optional.empty());
        return sedeRestaurante;
    }

}
