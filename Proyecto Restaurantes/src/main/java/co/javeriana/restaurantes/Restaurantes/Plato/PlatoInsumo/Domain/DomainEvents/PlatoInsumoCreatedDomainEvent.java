package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.DomainEvents;

import co.javeriana.restaurantes.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class PlatoInsumoCreatedDomainEvent extends DomainEvent {

    private String id;
    private String nombre;
    private int cantidadnecesaria;

    public PlatoInsumoCreatedDomainEvent(){
        super(null);
    }

    public PlatoInsumoCreatedDomainEvent(String aggregateId, String id, String nombre, int cantidadnecesaria) {
        super(aggregateId);
        this.id = id;
        this.nombre = nombre;
        this.cantidadnecesaria = cantidadnecesaria;
    }

    public PlatoInsumoCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String id, String nombre, int cantidadnecesaria) {
        super(aggregateId, eventId, occurredOn);
        this.id = id;
        this.nombre = nombre;
        this.cantidadnecesaria = cantidadnecesaria;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadnecesaria() {
        return cantidadnecesaria;
    }


    @Override
    public String eventName() {
        return "add.platoinsumo";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("id", id);
            put("nombre", nombre);
            put("cantidadnecesaria", cantidadnecesaria);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new PlatoInsumoCreatedDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("id"),
                (String) body.get("nombre"),
                (int) body.get("cantidadnecesaria"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoInsumoCreatedDomainEvent that = (PlatoInsumoCreatedDomainEvent) o;
        return cantidadnecesaria == that.cantidadnecesaria && id.equals(that.id) && nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, cantidadnecesaria);
    }
}
