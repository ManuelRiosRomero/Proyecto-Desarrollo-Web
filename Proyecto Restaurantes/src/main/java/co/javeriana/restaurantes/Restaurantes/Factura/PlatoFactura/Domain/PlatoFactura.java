package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.DomainEvents.PlatoFacturaCreatedDomainEvent;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.AggregateRoot;

import java.io.Serializable;
import java.util.HashMap;

public class PlatoFactura extends AggregateRoot implements Serializable {

    private String facturaID;

    public String getFacturaID() {return facturaID;}

    public void setFacturaID(String facturaID) {this.facturaID = facturaID;}

    private String platoID;

    public String getPlatoID() {return platoID;}

    public void setPlatoID(String platoID) {this.platoID = platoID;}

    private PlatoFacturaNombre nombre;
    private PlatoFacturaCantidad cantidad;
    private PlatoFacturaPrecio precio;

    public PlatoFactura(String facturaID, String platoID, PlatoFacturaNombre nombre, PlatoFacturaCantidad cantidad, PlatoFacturaPrecio precio) {
        this.facturaID = facturaID;
        this.platoID = platoID;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public static PlatoFactura create(String facturaID, String platoID, PlatoFacturaNombre nombre, PlatoFacturaCantidad cantidad, PlatoFacturaPrecio precio) {
        PlatoFactura platoFactura = new PlatoFactura(facturaID, platoID, nombre, cantidad, precio);
        platoFactura.record(new PlatoFacturaCreatedDomainEvent(facturaID, nombre.value(), cantidad.value(), precio.value()));
        return platoFactura;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", facturaID);
        data.put("nombre", nombre.value());
        data.put("facturaID", facturaID);
        data.put("platoID", platoID);
        data.put("cantidad", cantidad.value());
        data.put("precio", precio.value());
        return data;
    }

    private PlatoFactura(){}
}
