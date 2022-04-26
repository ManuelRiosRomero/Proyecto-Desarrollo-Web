package co.javeriana.restaurantes.Restaurantes.Factura.Application.Calculate;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.FacturaID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaCalculateTotal {
    private FacturaRepository repository;

    public FacturaCalculateTotal(FacturaRepository repository) {
        this.repository = repository;
    }

    public double execute(FacturaID facturaID) {
        List<Factura> facturas = new ArrayList<>();
        Optional<Factura> facturaOptional = repository.findByID(facturaID);
        //Se guaraa la factura
        if(facturaOptional.isPresent()){
            facturas.add(facturaOptional.get()) ;
            double propina = (double) facturas.get(0).data().get("propina");
            double valor = (double) facturas.get(0).data().get("valor");
            return propina + valor;
        }
        return -1;

    }
}
