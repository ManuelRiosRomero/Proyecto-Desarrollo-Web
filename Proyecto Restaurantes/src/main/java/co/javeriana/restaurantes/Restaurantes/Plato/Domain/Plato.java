package co.javeriana.restaurantes.Restaurantes.Plato.Domain;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.PlatoCosto;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.PlatoDescripcion;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.PlatoID;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.PlatoNombre;

import java.util.*;
import java.util.stream.Collectors;

public class Plato {
    private PlatoID id;
    private PlatoNombre nombre;
    private PlatoDescripcion descripcion;
    private PlatoCosto costo;
    private Optional<List<Insumo>> insumos;

    public Plato(PlatoID id, PlatoNombre nombre, PlatoDescripcion descripcion, PlatoCosto costo, Optional<List<Insumo>> insumos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.insumos = insumos;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id);
            put("nombre", nombre);
            put("descripcion", descripcion);
            put("isumos", createInsumos());
        }};
        return data;
    }

    private List<HashMap<String, Object>> createInsumos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!insumos.isEmpty()) {
            list = insumos.get().stream().map(insumo -> insumo.data()).collect(Collectors.toList());
        }
        return list;
    }

}
