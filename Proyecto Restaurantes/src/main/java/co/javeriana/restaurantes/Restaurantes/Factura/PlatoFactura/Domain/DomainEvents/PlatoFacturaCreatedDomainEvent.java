package co.javeriana.restaurantes.Restaurantes.Factura.PlatoFactura.Domain.DomainEvents;

import co.javeriana.restaurantes.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class PlatoFacturaCreatedDomainEvent extends DomainEvent {

    private String facturaId;
    private String nombre;
    private int cantidad;
    private double precio;

    public PlatoFacturaCreatedDomainEvent() {
        super(null);
    }

    public PlatoFacturaCreatedDomainEvent(String aggregateId, String facturaId, String nombre, int cantidad, double precio) {
        super(aggregateId);
        this.facturaId = facturaId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public PlatoFacturaCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String facturaId, String nombre, int cantidad, double precio) {
        super(aggregateId, eventId, occurredOn);
        this.facturaId = facturaId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getFacturaId() {
        return facturaId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String eventName() {
        return "add.platofactura";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<>(){{
            put("facturaID", facturaId);
            put("nombre", nombre);
            put("cantidad", cantidad);
            put("precio", precio);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new PlatoFacturaCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("facturaID"),
                (String) body.get("nombre"), (int) body.get("cantidad"), (double) body.get("precio"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoFacturaCreatedDomainEvent that = (PlatoFacturaCreatedDomainEvent) o;
        return cantidad == that.cantidad && Double.compare(that.precio, precio) == 0 && Objects.equals(facturaId, that.facturaId) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facturaId, nombre, cantidad, precio);
    }
}
