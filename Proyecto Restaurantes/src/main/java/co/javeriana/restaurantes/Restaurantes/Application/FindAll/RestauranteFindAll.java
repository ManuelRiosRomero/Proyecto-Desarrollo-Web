package co.javeriana.restaurantes.Restaurantes.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Domain.Ports.RestauranteRepository;
import co.javeriana.restaurantes.Restaurantes.Domain.Restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestauranteFindAll {
    private RestauranteRepository repository;

    public RestauranteFindAll(RestauranteRepository repository) {
        this.repository = repository;
    }

    public List<Restaurante> execute() {
        List<Restaurante> restaurantes = new ArrayList<>();
        Optional<List<Restaurante>> restaurantesOptional = repository.all();
        if (restaurantesOptional.isPresent()) {
            restaurantes = restaurantesOptional.get();
        }
        return restaurantes;
    }
}
