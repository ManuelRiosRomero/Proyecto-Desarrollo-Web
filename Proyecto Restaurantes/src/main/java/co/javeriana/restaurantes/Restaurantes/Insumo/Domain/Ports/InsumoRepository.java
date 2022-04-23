package co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.InsumoID;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.RestauranteID;

import java.util.List;
import java.util.Optional;


public interface InsumoRepository {
    void save(Insumo insumo);
    void update(Insumo insumo);
    Optional<Insumo> find(InsumoID insumoId);
    Optional<List<Insumo>> all();
    void delete(Insumo insumo);
}
