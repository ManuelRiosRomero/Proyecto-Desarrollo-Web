package co.javeriana.restaurantes.Restaurantes.Insumo.Domain;

import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.DomainEvents.InsumoCreatedDomainEvent;
import co.javeriana.restaurantes.Restaurantes.Insumo.Domain.ValueObjects.*;
import co.javeriana.restaurantes.Shared.Domain.Aggregate.AggregateRoot;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

public class Insumo extends AggregateRoot {

    private InsumoID id;
    private InsumoCantidad cantidad;
    private InsumoNombre nombre;
    private InsumoCosto costo;
    private RestauranteID restauranteId;

    public Insumo(InsumoID id, InsumoCantidad cantidad, InsumoNombre nombre, InsumoCosto costo, RestauranteID restauranteId) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.costo = costo;
        this.restauranteId = restauranteId;
    }

    //TODO Create INSUMO DOMAIN EVENT



    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("id", id.value());
            put("cantidad", cantidad.value());
            put("nombre", nombre.value());
            put("costo",costo.value());
            put("restauranteId",restauranteId.value());
        }};
        return data;
    }

    public static Insumo create(InsumoID id, InsumoCantidad cantidad, InsumoNombre nombre, InsumoCosto costo, RestauranteID resId) {
        Insumo insumo = new Insumo(id, cantidad, nombre, costo, resId);
        insumo.record(new InsumoCreatedDomainEvent(id.value(), cantidad.value(), nombre.value(), costo.value(), resId.value()));
        return insumo;
    }

    private Insumo() {}

}
