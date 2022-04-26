package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Application.FindAll;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.PlatoFactura;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.Ports.PlatoFacturaRepository;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlatoFacturaFindAll {

    private PlatoFacturaRepository repository;
    private final EventBus eventBus;

    public PlatoFacturaFindAll(PlatoFacturaRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public List<PlatoFactura> execute() {
        List<PlatoFactura> platoFacturas = new ArrayList<>();
        Optional<List<PlatoFactura>> optionalPlatoFacturaList = repository.all();
        if(optionalPlatoFacturaList.isPresent()) {
            platoFacturas = optionalPlatoFacturaList.get();
        }
        return platoFacturas;
    }

}
