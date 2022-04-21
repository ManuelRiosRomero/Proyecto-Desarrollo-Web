package co.javeriana.restaurantes.Restaurantes.Inventario.Domain;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventario {
    private Optional<List<Insumo>> insumos;

    public Inventario(Optional<List<Insumo>> insumos) {
        this.insumos = insumos;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
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
