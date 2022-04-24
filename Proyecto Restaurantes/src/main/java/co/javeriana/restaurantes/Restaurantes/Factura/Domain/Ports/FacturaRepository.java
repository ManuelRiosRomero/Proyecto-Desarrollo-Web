package co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.FacturaID;

import java.util.List;
import java.util.Optional;

public interface FacturaRepository {
    void save(Factura factura);
    void update(Factura factura);
    Optional<Factura> findByID(FacturaID facturaId);
    Optional<List<Factura>> all();
    void delete(Factura factura);


}
