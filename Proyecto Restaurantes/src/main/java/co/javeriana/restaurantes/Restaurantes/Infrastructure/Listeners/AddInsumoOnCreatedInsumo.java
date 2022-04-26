package co.javeriana.restaurantes.Restaurantes.Infrastructure.Listeners;

import co.javeriana.restaurantes.Restaurantes.Application.AddInsumo.RestauranteAddInsumo;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.DomainEvents.InsumoCreatedDomainEvent;

public class AddInsumoOnCreatedInsumo {
    private RestauranteAddInsumo adder;

    public AddInsumoOnCreatedInsumo(RestauranteAddInsumo adder) {
        this.adder = adder;
    }

    public void on(InsumoCreatedDomainEvent event) {
       adder.execute(event.getRestauranteId(), event.aggregateId(), event.getNombre(), event.getCantidad(), event.getCosto());
    }
}
