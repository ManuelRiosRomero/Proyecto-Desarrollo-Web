package co.javeriana.restaurantes.Restaurantes.Factura.Application.FindById;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.FacturaID;

import java.util.Optional;

public class FacturaFindById {

    private FacturaRepository repository;

    public FacturaFindById(FacturaRepository repository) {
        this.repository = repository;
    }

    public Factura execute(String id) {
        Factura factura = null;
        Optional<Factura> optionalFactura = repository.findByID(new FacturaID(id));
        if (optionalFactura.isPresent()) {
            factura = optionalFactura.get();
        }
        return factura;
    }
}
