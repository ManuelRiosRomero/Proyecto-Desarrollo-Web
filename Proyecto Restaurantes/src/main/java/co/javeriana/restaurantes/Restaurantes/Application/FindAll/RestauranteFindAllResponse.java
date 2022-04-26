package co.javeriana.restaurantes.Restaurantes.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Domain.Restaurante;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RestauranteFindAllResponse {

    private List<Restaurante> restaurantes;

    public RestauranteFindAllResponse(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public List<HashMap<String,Object>> response(){
        List<HashMap<String,Object>> response = restaurantes.stream().map(res->res.data()).collect(Collectors.toList());
        return response;
    }



}
