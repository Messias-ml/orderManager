package messiasproject.microservicespecialist.order.domain.implementation.events;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;
import messiasproject.microservicespecialist.order.infra.event.NotifyCreateItem;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventCreateItemImplementation implements NotifyCreateItem {
    private final ApplicationEventPublisher publisher;


    @Override
    public void eventCreateItem(OrderRecivedDTO order) {
        publisher.publishEvent(order);
    }
}
