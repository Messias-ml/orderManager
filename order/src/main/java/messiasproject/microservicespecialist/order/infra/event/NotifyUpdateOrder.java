package messiasproject.microservicespecialist.order.infra.event;

import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;

public interface NotifyUpdateOrder {
    void eventUpdateOrder(OrderEntity order);
}
