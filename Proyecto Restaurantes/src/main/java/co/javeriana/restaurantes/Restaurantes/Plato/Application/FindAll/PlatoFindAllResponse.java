package co.javeriana.restaurantes.Restaurantes.Plato.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PlatoFindAllResponse {

    private List<Plato> platos;

    public PlatoFindAllResponse(List<Plato> platos) {
        this.platos = platos;
    }

    public List<HashMap<String,Object>> response(){
        List<HashMap<String,Object>> response = platos.stream().map(plato -> plato.data()).collect(Collectors.toList());
        return response;
    }
}
