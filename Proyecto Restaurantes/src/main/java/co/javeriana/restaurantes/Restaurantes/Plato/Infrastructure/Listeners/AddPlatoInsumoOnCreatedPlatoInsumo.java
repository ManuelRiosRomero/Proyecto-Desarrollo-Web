package co.javeriana.restaurantes.Restaurantes.Plato.Infrastructure.Listeners;

import co.javeriana.restaurantes.Restaurantes.Plato.Application.AddPlatoInsumo.PlatoAddPlatoInsumo;
import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.DomainEvents.PlatoInsumoCreatedDomainEvent;

public final class AddPlatoInsumoOnCreatedPlatoInsumo {
    private PlatoAddPlatoInsumo adder;

    public AddPlatoInsumoOnCreatedPlatoInsumo(PlatoAddPlatoInsumo adder) {
        this.adder = adder;
    }

    public void on(PlatoInsumoCreatedDomainEvent event) {
        adder.execute(event.getIdplato(), event.aggregateId(), event.getCantidadnecesaria(),event.getNombre());

    }
}
