package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.PlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.Ports.PlatoInsumoRepository;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.InsumoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoID;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoCantidadNecesaria;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.ValueObjects.PlatoInsumoNombre;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;

public class PlatoInsumoCreate {

    private PlatoInsumoRepository repository;
    private final EventBus eventBus;

    public PlatoInsumoCreate(PlatoInsumoRepository repository, EventBus eventBus){
        this.repository = repository;
        this.eventBus = eventBus;
    }
    public void execute(String insumoID, String nombreInsumo, String platoID, int cantidad)
    {
        PlatoInsumo platoInsumo = PlatoInsumo.create(new InsumoID(insumoID), new PlatoInsumoNombre(nombreInsumo), new PlatoID(platoID), new PlatoInsumoCantidadNecesaria(cantidad));
        repository.save(platoInsumo);
        //Publicar evento de creación de insumo plato
        this.eventBus.publish(platoInsumo.pullDomainEvents());

    }
}
