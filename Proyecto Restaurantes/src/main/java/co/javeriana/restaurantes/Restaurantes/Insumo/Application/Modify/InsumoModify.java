package co.javeriana.restaurantes.Restaurantes.Insumo.Application.Modify;

import co.javeriana.restaurantes.Restaurantes.Insumo.Application.FindByID.InsumoFindById;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InsumoModify {
    InsumoRepository repository;
    private final EventBus eventBus;

    public InsumoModify(InsumoRepository insumoRepository, EventBus eventBus) {
        this.repository = insumoRepository;
        this.eventBus = eventBus;
    }

    public Insumo execute(String id, int cantidad) {
        Insumo insumo = null;
        Optional<Insumo> optionalInsumo = repository.find(new InsumoID(id));
        if(optionalInsumo.isPresent()){
            insumo = optionalInsumo.get();
          //--
        }
        return insumo;
    }

}
