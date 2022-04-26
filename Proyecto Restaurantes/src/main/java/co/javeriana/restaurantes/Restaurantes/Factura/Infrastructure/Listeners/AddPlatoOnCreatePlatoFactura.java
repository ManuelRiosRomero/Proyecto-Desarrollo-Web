package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Listeners;

import co.javeriana.restaurantes.Restaurantes.Factura.Application.AddPlatoFactura.FacturaAddPlato;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.DomainEvents.PlatoFacturaCreatedDomainEvent;

public class AddPlatoOnCreatePlatoFactura {

    private FacturaAddPlato adder;

    public AddPlatoOnCreatePlatoFactura(FacturaAddPlato adder) {
        this.adder = adder;
    }

    public void on(PlatoFacturaCreatedDomainEvent event) {
        adder.execute(event.getFacturaId(), event.aggregateId(), event.getNombre(), event.getCantidad(), event.getPrecio());
    }

}
