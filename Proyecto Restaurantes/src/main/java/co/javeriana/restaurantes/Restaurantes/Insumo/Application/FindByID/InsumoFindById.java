package co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindByID;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.InsumoID;

import java.util.Optional;

public class InsumoFindById {

    private InsumoRepository repository;

    public InsumoFindById(InsumoRepository repository){
        this.repository = repository;
    }

    public Insumo execute(String id){
        Insumo insumo = null;
        Optional<Insumo> optionalInsumo = repository.find(new InsumoID(id));
        if(optionalInsumo.isPresent()){
            insumo = optionalInsumo.get();
        }
        return insumo;
    }
}
