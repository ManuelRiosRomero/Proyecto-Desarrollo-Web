package co.javeriana.restaurantes.Restaurantes.Domain;

import co.javeriana.restaurantes.Restaurantes.Domain.Entities.InsumoRestaurante;
import co.javeriana.restaurantes.Restaurantes.Empleado.Domain.Empleado;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Domain.Entities.Ubicacion;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.RestauranteID;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.AggregateRoot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Restaurante {

    private RestauranteID id;
    private Ubicacion ubicacion;
    private Optional<List<Empleado>> empleados;
    private Optional<List<InsumoRestaurante>> insumos;
    private Optional<List<Plato>> platos;

    public Restaurante(RestauranteID id, Ubicacion ubicacion, Optional<List<Empleado>> empleados, Optional<List<InsumoRestaurante>> insumos, Optional<List<Plato>> platos) {
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
            put("insumos", createInsumos());
            put("platos", createPlatos());
        }};
        return data;
    }

    private List<HashMap<String, Object>> createEmpleados() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if(empleados != null)
        if (empleados.isPresent()) {
            list = empleados.get().stream().map(empleado -> empleado.data()).collect(Collectors.toList());
        }
        return list;
    }

    private List<HashMap<String, Object>> createInsumos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if(insumos != null)
        if (insumos.isPresent()) {
            list = insumos.get().stream().map(insumo -> insumo.data()).collect(Collectors.toList());
        }
        return list;
    }

    private List<HashMap<String, Object>> createPlatos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if(platos != null)
        if (platos.isPresent()) {
            list = platos.get().stream().map(plato -> plato.data()).collect(Collectors.toList());
        }
        return list;
    }

    public Restaurante create(RestauranteID id, Ubicacion ubicacion) {
        Restaurante restaurante = new Restaurante(id, ubicacion, Optional.of(new ArrayList<>()), Optional.of(new ArrayList<>()),Optional.of(new ArrayList<>()));
        return restaurante;
    }

    public void addInsumo(InsumoRestaurante insumoRestaurante) {
        List<InsumoRestaurante> lstInsumos = new ArrayList<>();
        if (insumos.isPresent()) {
            lstInsumos = insumos.get();
        }
        //Find if the insumo is already in the list
        Optional<InsumoRestaurante> insumo = lstInsumos.stream().filter(ins -> ins.data().get("id").equals(insumoRestaurante.data().get("id"))).findFirst();
        //If not present, add it
        if (!insumo.isPresent()) {
            lstInsumos.add(insumoRestaurante);
        }
        else{ //delete the old one and add the new one
            lstInsumos.remove(insumo.get());
            lstInsumos.add(insumoRestaurante);
        }
        this.insumos=Optional.ofNullable(lstInsumos);
    }

    private Restaurante(){};

}
