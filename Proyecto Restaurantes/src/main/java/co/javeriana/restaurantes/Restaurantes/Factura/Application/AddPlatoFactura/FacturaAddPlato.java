package co.javeriana.restaurantes.Restaurantes.Factura.Application.AddPlatoFactura;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Entities.FacturaPlato;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.FacturaID;

import java.util.Optional;

public class FacturaAddPlato {

    private FacturaRepository repository;

    public FacturaAddPlato(FacturaRepository repository) {
        this.repository = repository;
    }

    public void execute(String facturaId, String platoId, String nombre, int cantidad, double precio) {
        Optional<Factura> optionalFactura = repository.findByID(new FacturaID(facturaId));
        if(optionalFactura.isPresent()) {
            Factura fact = optionalFactura.get();
            fact.addPlato(new FacturaPlato(platoId, nombre, cantidad, precio));
            this.repository.update(fact);
        }
    }

}
