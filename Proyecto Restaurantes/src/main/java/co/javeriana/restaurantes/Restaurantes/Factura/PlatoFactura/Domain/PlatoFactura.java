package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain;

import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.DomainEvents.PlatoFacturaCreatedDomainEvent;
import co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.AggregateRoot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

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
        platoFactura.record(
                new PlatoFacturaCreatedDomainEvent(
                        platoID,
                        facturaID,
                        nombre.value(),
                        cantidad.value(),
                        precio.value()
        ));
        return platoFactura;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("nombre", nombre.value());
        data.put("facturaID", facturaID);
        data.put("platoID", platoID);
        data.put("cantidad", cantidad.value());
        data.put("precio", precio.value());
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoFactura that = (PlatoFactura) o;
        return Objects.equals(facturaID, that.facturaID) && Objects.equals(platoID, that.platoID) && Objects.equals(nombre, that.nombre) && Objects.equals(cantidad, that.cantidad) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facturaID, platoID, nombre, cantidad, precio);
    }

    private PlatoFactura(){}
}
