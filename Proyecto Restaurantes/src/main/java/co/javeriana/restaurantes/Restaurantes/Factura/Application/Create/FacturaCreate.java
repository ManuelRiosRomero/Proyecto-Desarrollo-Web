package co.javeriana.restaurantes.Restaurantes.Factura.Application.Create;

import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Factura;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.Ports.FacturaRepository;
import co.javeriana.restaurantes.Restaurantes.Factura.Domain.ValueObjects.*;

public class FacturaCreate {

    private FacturaRepository repository;

    public FacturaCreate(FacturaRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, double valor, String fecha, double propina, String resId) {
        Factura factura = Factura.create(new FacturaID(id), new FacturaValor(valor), new FacturaFecha(fecha), new FacturaPropina(propina), new RestauranteID(resId));
        repository.save(factura);
    }
}
