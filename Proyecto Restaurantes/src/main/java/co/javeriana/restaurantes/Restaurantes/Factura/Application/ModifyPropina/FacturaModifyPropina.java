package co.javeriana.restaurantes.Restaurantes.Factura.Application.ModifyPropina;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;

public class FacturaModifyPropina {
    private FacturaRepository repository;

    public FacturaModifyPropina (FacturaRepository repository) {
        this.repository = repository;
    }

}
