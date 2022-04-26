package co.javeriana.restaurantes.Shared.Infrastructure.RabbitMQ.Serializable;

import co.javeriana.restaurantes.Shared.Domain.Bus.Event.DomainEvent;
import co.javeriana.restaurantes.Shared.Infrastructure.RabbitMQ.DomainEventsInformation;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

public class DomainEventJsonDeserializer {

    private final DomainEventsInformation information;

    public DomainEventJsonDeserializer(DomainEventsInformation information) {
        this.information = information;
    }

    public DomainEvent deserialize(String body) throws Exception {
        HashMap<String, Serializable> eventData = this.jsonDecode(body);
        HashMap<String, Serializable> data = (HashMap<String, Serializable>) eventData.get("data");
        HashMap<String, Serializable> attributes = (HashMap<String, Serializable>) data.get("attributes");
        Class<? extends DomainEvent> domainEventClass = information.getDomainEvent((String) data.get("type"));

        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();
        Method fromPrimitivesMethod = domainEventClass.getMethod("fromPrimitive", String.class,
                HashMap.class, String.class, String.class);

        Object domainEvent = fromPrimitivesMethod.invoke(nullInstance,
                (String) attributes.get("id"), attributes,
                (String) data.get("id"), (String) data.get("occurred_on"));

        return (DomainEvent) domainEvent;
    }

    public HashMap<String, Serializable> jsonDecode(String body) {
        try {
            return new ObjectMapper().readValue(body, HashMap.class);
        }
        catch (Exception e) {
            return null;
        }
    }
}
