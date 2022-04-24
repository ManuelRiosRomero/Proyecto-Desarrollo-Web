package co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InsumoFindAllResponse {

    private List<Insumo> insumos;

    public InsumoFindAllResponse(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = insumos.stream().map(insu-> insu.data()).collect(Collectors.toList());
        return response;
    }
}
