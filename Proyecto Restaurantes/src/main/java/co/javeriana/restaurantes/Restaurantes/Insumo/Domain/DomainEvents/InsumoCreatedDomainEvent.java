package co.javeriana.restaurantes.Restaurantes.Insumo.Domain.DomainEvents;

import co.javeriana.restaurantes.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class InsumoCreatedDomainEvent extends DomainEvent {

    private int cantidad;
    private String nombre;
    private double costo;
    private String restauranteId;

    //Constructor vacio
    public InsumoCreatedDomainEvent() {
        super(null);
    }

    //Constructor con solo los atributos de Insumo
    public InsumoCreatedDomainEvent(int cantidad, String nombre, double costo, String restauranteId) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.costo = costo;
        this.restauranteId = restauranteId;
    }

    //Constructor con atributos de insumo mas el aggregateId
    public InsumoCreatedDomainEvent(String aggregateId, int cantidad, String nombre, double costo, String restauranteId) {
        super(aggregateId);
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.costo = costo;
        this.restauranteId = restauranteId;
    }

    //Constructo con todos los atributos tanto del insumo como de DomainEvent
    public InsumoCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, int cantidad, String nombre, double costo, String restauranteId) {
        super(aggregateId, eventId, occurredOn);
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.costo = costo;
        this.restauranteId = restauranteId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public String getRestauranteId() {
        return restauranteId;
    }

    @Override
    public String eventName() {
        return "add.insumo";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("cantidad", cantidad);
            put("nombre", nombre);
            put("costo", costo);
            put("restauranteId", restauranteId);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new InsumoCreatedDomainEvent(
                aggregateId, eventId, occurredOn, (int)body.get("cantidad"), (String)body.get("nombre"), (double)body.get("costo"),
                (String)body.get("restauranteId")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsumoCreatedDomainEvent that = (InsumoCreatedDomainEvent) o;
        return cantidad == that.cantidad && Double.compare(that.costo, costo) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(restauranteId, that.restauranteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, nombre, costo, restauranteId);
    }
}
