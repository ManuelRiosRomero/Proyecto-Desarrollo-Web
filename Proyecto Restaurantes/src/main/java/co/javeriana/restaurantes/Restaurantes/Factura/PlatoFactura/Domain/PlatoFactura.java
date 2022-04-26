package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.DomainEvents.PlatoFacturaCreatedDomainEvent;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.AggregateRoot;

import java.util.HashMap;

public class PlatoFactura extends AggregateRoot {
    private FacturaID facturaID;
    private PlatoID platoID;
    private PlatoFacturaNombre nombre;
    private PlatoFacturaCantidad cantidad;
    private PlatoFacturaPrecio precio;

    public PlatoFactura(FacturaID insumoID, PlatoID platoID, PlatoFacturaNombre nombre, PlatoFacturaCantidad cantidad, PlatoFacturaPrecio precio) {
        this.facturaID = insumoID;
        this.platoID = platoID;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public static PlatoFactura create(FacturaID facturaID, PlatoID platoID, PlatoFacturaNombre nombre, PlatoFacturaCantidad cantidad, PlatoFacturaPrecio precio) {
        PlatoFactura platoFactura = new PlatoFactura(facturaID, platoID, nombre, cantidad, precio);
        platoFactura.record(new PlatoFacturaCreatedDomainEvent(facturaID.value(), nombre.value(), cantidad.value(), precio.value()));
        return platoFactura;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", facturaID.value());
        data.put("nombre", nombre.value());
        data.put("platoID", platoID.value());
        data.put("cantidad", cantidad.value());
        data.put("precio", precio.value());
        return data;
    }

    private PlatoFactura(){}
}
