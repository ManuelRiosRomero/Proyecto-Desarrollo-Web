package co.javeriana.restaurantes.Restaurantes.Domain.Ports;

import co.javeriana.restaurantes.Restaurantes.Domain.Restaurante;
import co.javeriana.restaurantes.Restaurantes.Domain.ValueObjects.RestauranteID;

import java.util.List;
import java.util.Optional;

public interface RestauranteRepository {

    void save(Restaurante restaurante);
    void update(Restaurante restaurante);
    Optional<Restaurante> findById(RestauranteID id);
    Optional<List<Restaurante>> all();
    void delete(Restaurante restaurante);
}
