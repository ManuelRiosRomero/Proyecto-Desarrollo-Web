package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.Ports;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoID;

import java.util.List;
import java.util.Optional;

public interface PlatoInsumoRepository {

    void save(PlatoInsumo platoInsumo);
    void update(PlatoInsumo platoInsumo);

    Optional<List<PlatoInsumo>> findByPlatoId(PlatoID platoID);
    Optional<List<PlatoInsumo>> findByPlatoIdAndInsumoID(String platoID, String insumoID);

    Optional<List<PlatoInsumo>> findByInsumoId(String insumoID);
    Optional<List<PlatoInsumo>> all();
    void delete(PlatoInsumo platoInsumo);
}
