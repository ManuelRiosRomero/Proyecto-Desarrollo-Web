package co.javeriana.restaurantes.Shared.Domain.Bus.Event;

import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);
}
