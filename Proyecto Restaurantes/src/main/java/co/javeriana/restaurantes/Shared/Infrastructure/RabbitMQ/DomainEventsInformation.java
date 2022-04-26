package co.javeriana.restaurantes.Shared.Infrastructure.RabbitMQ;

import co.javeriana.restaurantes.Restaurantes.Plato.PlatoInsumo.Domain.DomainEvents.PlatoInsumoCreatedDomainEvent;
import co.javeriana.restaurantes.Shared.Domain.Bus.Event.DomainEvent;

//import com.webdev.productsystem.Users.Address.Domain.DomainEvents.AddressCreatedDomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {

    private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvent = new HashMap<>();
    private final HashMap<String, String> domainEventSubscribers = new HashMap<>();

    public DomainEventsInformation() {
        //TODO : Agregar los eventos que se van a usar
        //Eventos de dominio
        indexedDomainEvent.put("add.platoinsumo", PlatoInsumoCreatedDomainEvent.class);
        //Suscriptores de eventos
        domainEventSubscribers.put("restaurantsSystem.restaurantes.plato.platoinsumo.add.platoinsumo", "AddPlatoInsumoOnCreatedPlatoInsumo");

    }

    public Class<? extends DomainEvent> getDomainEvent(String name) {
        return indexedDomainEvent.get(name);
    }

    public boolean validateEventSubscriber(String name) {
        return domainEventSubscribers.containsKey(name);
    }

    public String getEventSubscriber(String name) {
        return domainEventSubscribers.get(name);
    }
}
