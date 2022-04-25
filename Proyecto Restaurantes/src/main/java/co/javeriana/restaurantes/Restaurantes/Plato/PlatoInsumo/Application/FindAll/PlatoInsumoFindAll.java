package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.Ports.PlatoInsumoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlatoInsumoFindAll {

    private PlatoInsumoRepository repository;

    public PlatoInsumoFindAll(PlatoInsumoRepository repository) {
        this.repository = repository;
    }

    public List<PlatoInsumo> execute(){
        List<PlatoInsumo> platoInsumos = new ArrayList<>();
        Optional<List<PlatoInsumo>> optionalPlatoInsumoList = repository.all();
        if(optionalPlatoInsumoList.isPresent()){
            platoInsumos = optionalPlatoInsumoList.get();
        }
        return platoInsumos;
    }
}
