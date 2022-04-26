package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.PlatoFactura;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.Ports.PlatoFacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;

public class PlatoFacturaCreate {

    private PlatoFacturaRepository repository;
    private final EventBus eventBus;

    public PlatoFacturaCreate(PlatoFacturaRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String facturaID, String platoId, String nombre, int cantidad, double precio) {
        PlatoFactura platoFactura = PlatoFactura.create(facturaID, platoId,
                new PlatoFacturaNombre(nombre), new PlatoFacturaCantidad(cantidad), new PlatoFacturaPrecio(precio));
        repository.save(platoFactura);
        this.eventBus.publish(platoFactura.pullDomainEvents());
    }

}
