package co.javeriana.restaurantes.Restaurantes.Plato.Domain;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Entities.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.*;

import java.util.*;
import java.util.stream.Collectors;

public class Plato {
    private PlatoID id;
    private PlatoNombre nombre;
    private PlatoDescripcion descripcion;
    private PlatoCosto costo;
    private Optional<List<PlatoInsumo>> insumosList;
    private RestauranteID resId;

    public Plato(PlatoID id, PlatoNombre nombre, PlatoDescripcion descripcion, PlatoCosto costo, Optional<List<PlatoInsumo>> insumos, RestauranteID resId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.insumosList = insumos;
        this.resId = resId;
    }

    public static Plato create(PlatoID id, PlatoNombre nombre, PlatoDescripcion descripcion, PlatoCosto costo, RestauranteID resId) {
        Plato plato = new Plato(
                id,
                nombre,
                descripcion,
                costo,
                Optional.of(new ArrayList<>()),
                resId);
        return plato;
    }

    public void addInsumo(PlatoInsumo platoInsumo) {
        List<PlatoInsumo> platosinsumos = new ArrayList<>();
        if (insumosList.isPresent()) {
            platosinsumos = insumosList.get();
        }
        platosinsumos.add(platoInsumo);
        this.insumosList=Optional.ofNullable(platosinsumos);
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id.value());
            put("nombre", nombre.value());
            put("costo", costo.value());
            put("descripcion", descripcion.value());
            put("insumos", createInsumos());
            put("resId", resId.value());
        }};
        return data;
    }

    private List<HashMap<String, Object>> createInsumos() {
        List<HashMap<String, Object>> list = new ArrayList<>();
        if (!insumosList.isEmpty()) {
            list = insumosList.get().stream().map(insumo -> insumo.data()).collect(Collectors.toList());
        }
        return list;
    }

    private Plato(){insumosList = Optional.empty();}

}
