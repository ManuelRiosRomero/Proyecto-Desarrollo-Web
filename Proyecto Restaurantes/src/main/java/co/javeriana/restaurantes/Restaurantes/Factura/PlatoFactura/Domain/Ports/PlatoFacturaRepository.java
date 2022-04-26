package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.Ports;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.PlatoFactura;

import java.util.List;
import java.util.Optional;

public interface PlatoFacturaRepository {

    void save(PlatoFactura platoFactura);
    void update(PlatoFactura platoFactura);
    Optional<List<PlatoFactura>> findByPlatoFacturaID(String platoID, String facturaID);
    Optional<List<PlatoFactura>> all();
    void delete(PlatoFactura platoFactura);

}
