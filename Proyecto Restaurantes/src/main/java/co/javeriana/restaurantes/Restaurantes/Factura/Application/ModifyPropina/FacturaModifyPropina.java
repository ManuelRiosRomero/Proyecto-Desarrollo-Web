package co.javeriana.restaurantes.Restaurantes.Factura.Application.ModifyPropina;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.FacturaID;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.Ports.InsumoRepository;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaModifyPropina {
    private FacturaRepository repository;

    public FacturaModifyPropina (FacturaRepository repository) {
        this.repository = repository;
    }

    public Factura execute(FacturaID facturaID, Double nuevaPropina) {
        Factura facturas = null;
        Optional<Factura> facturaOptional = repository.findByID(facturaID);
        //Se guaraa la factura
        if(facturaOptional.isPresent()){
            facturas = facturaOptional.get();
            facturas.data().put("propina",nuevaPropina);
        }
        return facturas;

    }

}
