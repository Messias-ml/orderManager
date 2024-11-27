package messiasproject.microservicespecialist.order.domain.implementation.events;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.event.NotifyUpdateOrder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventUpdateOrderImplementation implements NotifyUpdateOrder {
    private final ApplicationEventPublisher publisher;
    @Override
    public void eventUpdateOrder(OrderEntity orderEntity) {
        publisher.publishEvent(orderEntity);
    }

}
