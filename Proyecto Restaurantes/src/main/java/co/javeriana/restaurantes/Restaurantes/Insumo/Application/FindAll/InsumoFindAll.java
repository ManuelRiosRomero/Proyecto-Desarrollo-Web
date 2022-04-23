package co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InsumoFindAll {
    private InsumoRepository repository;

    public InsumoFindAll(InsumoRepository repository) {
        this.repository = repository;
    }

    public List<Insumo> execute(){
        List<Insumo> insumos = new ArrayList<>();
        Optional<List<Insumo>> optionalInsumos = repository.all();
        if(optionalInsumos.isPresent()){
            insumos = optionalInsumos.get();
        }
        return insumos;
    }
}
