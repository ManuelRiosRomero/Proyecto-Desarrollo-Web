package co.javeriana.restaurantes.Shared.Infrastructure.RabbitMQ;

import co.javeriana.restaurantes.Shared.Domain.Bus.Event.DomainEvent;
import co.javeriana.restaurantes.Shared.Infrastructure.RabbitMQ.Serializable.DomainEventJsonDeserializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class RabbitMqDomainEventsConsumer {

    private final DomainEventsInformation information;
    private final DomainEventJsonDeserializer deserializer;

    @Autowired
    private final ApplicationContext context;

    public RabbitMqDomainEventsConsumer(DomainEventsInformation information, DomainEventJsonDeserializer deserializer, ApplicationContext context) {
        this.information = information;
        this.deserializer = deserializer;
        this.context = context;
    }

    @RabbitListener(queues = "#{'${rabbit.queues}'.split(',')}")
    public void consume(Message message) throws Exception {
        String serializedMessage = new String(message.getBody());
        DomainEvent domainEvent = deserializer.deserialize(serializedMessage);
        String queueName = message.getMessageProperties().getConsumerQueue();
        Object subscriber = this.subscriberFor(queueName);
        try {
            System.out.println("Llego un evento de dominio: " + domainEvent.getClass().getSimpleName());
            Method subscriberOnMethod = subscriber.getClass().getMethod("on", domainEvent.getClass());
            subscriberOnMethod.invoke(subscriber, domainEvent);
        }
        catch (Exception error) {
            throw new Exception("Error Listener: " + error.toString());
        }
    }

    private Object subscriberFor(String queueName) throws Exception {
        if(!this.information.validateEventSubscriber(queueName)) {
            throw new Exception("No hay listener asociado a la cola " + queueName);
        }
        String eventSubscriberName = this.information.getEventSubscriber(queueName);
        return context.getBean(eventSubscriberName);
    }
}
