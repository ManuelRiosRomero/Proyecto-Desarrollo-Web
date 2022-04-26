package co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.DomainEvents;

import co.javeriana.restaurantes.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class PlatoInsumoCreatedDomainEvent extends DomainEvent {

    private String nombre;
    private int cantidadnecesaria;
    private String idplato;

    public PlatoInsumoCreatedDomainEvent(){
        super(null);
    }

    public PlatoInsumoCreatedDomainEvent(String aggregateId, String nombre, int cantidadnecesaria,String idplato) {
        super(aggregateId);
        this.nombre = nombre;
        this.cantidadnecesaria = cantidadnecesaria;
        this.idplato = idplato;
    }

    public PlatoInsumoCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String nombre, int cantidadnecesaria,String idplato) {
        super(aggregateId, eventId, occurredOn);
        this.nombre = nombre;
        this.cantidadnecesaria = cantidadnecesaria;
        this.idplato = idplato;
    }

    public String getIdplato() {
        return idplato;
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
            put("nombreinsumo", nombre);
            put("cantidadnecesaria", cantidadnecesaria);
            put("platoid", idplato);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new PlatoInsumoCreatedDomainEvent(aggregateId, eventId, occurredOn,
                (String) body.get("nombreinsumo"),
                (int) body.get("cantidadnecesaria"),
                (String) body.get("platoid"));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoInsumoCreatedDomainEvent that = (PlatoInsumoCreatedDomainEvent) o;
        return cantidadnecesaria == that.cantidadnecesaria && Objects.equals(nombre, that.nombre) && Objects.equals(idplato, that.idplato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cantidadnecesaria, idplato);
    }
}
