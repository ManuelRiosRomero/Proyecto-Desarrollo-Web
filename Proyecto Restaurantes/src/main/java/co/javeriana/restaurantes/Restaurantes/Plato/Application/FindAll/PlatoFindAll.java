package co.javeriana.restaurantes.Restaurantes.Plato.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Plato;
import co.javeriana.restaurantes.Restaurantes.Plato.Domain.Ports.PlatoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlatoFindAll {

    private PlatoRepository repository;

    public PlatoFindAll(PlatoRepository repository){
        this.repository = repository;
    }

    public List<Plato> execute(){
        List<Plato> platos = new ArrayList<>();
        Optional<List<Plato>> optionalPlatos = repository.all();
        if(optionalPlatos.isPresent()){
            platos = optionalPlatos.get();
        }
        return platos;
    }
}
