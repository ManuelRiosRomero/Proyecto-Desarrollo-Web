package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.PlatoInsumo;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlatoInsumoFindAllResponse {

    private List<PlatoInsumo> platoInsumos;

    public PlatoInsumoFindAllResponse(List<PlatoInsumo> platoInsumos) {
        this.platoInsumos = platoInsumos;
    }
    public List<HashMap<String,Object>> response(){
        List<HashMap<String,Object>> response = platoInsumos.stream().map(platoInsumo -> platoInsumo.data()).collect(Collectors.toList());
        return response;
    }
}
