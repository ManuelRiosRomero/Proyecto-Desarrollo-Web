package co.javeriana.restaurantes.Restaurantes.Plato.Domain.Ports;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.ValueObjects.PlatoID;

import java.util.List;
import java.util.Optional;

public interface PlatoRepository {

    void save(Plato plato);
    void update(Plato plato);
    Optional<Plato> findByID(PlatoID platoID);
    Optional<List<Plato>> all();
    void delete(Plato plato);
}
