package co.javeriana.restaurantes.Restaurantes.Factura.Infrastructure.Listeners;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.DomainEvents.PlatoFacturaCreatedDomainEvent;

public class AddPlatoOnCreatePlatoFactura {

    public void on(PlatoFacturaCreatedDomainEvent event) {
        System.out.println("El evento llego con el plato asociado: " + event.getNombre());
    }

}
