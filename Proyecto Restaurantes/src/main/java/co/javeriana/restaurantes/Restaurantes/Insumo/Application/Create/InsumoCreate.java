package co.javeriana.restaurantes.Restaurantes.Insumo.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Insumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;

public class InsumoCreate {

    InsumoRepository insumoRepository;
    private final EventBus eventBus;

    public InsumoCreate(InsumoRepository insumoRepository, EventBus eventBus) {
        this.insumoRepository = insumoRepository;
        this.eventBus = eventBus;
    }

    public void execute(String id, int cantidad, String nombre, double costo, String restauranteId) {
        Insumo insumo = Insumo.create(new InsumoID(id), new InsumoCantidad(cantidad), new InsumoNombre(nombre), new InsumoCosto(costo),
                new RestauranteID(restauranteId));
        insumoRepository.save(insumo);
        this.eventBus.publish(insumo.pullDomainEvents());
    }
}
