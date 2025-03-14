package messiasproject.microservicespecialist.order.infra.rabbitmq.consumer;

import messiasproject.microservicespecialist.order.application.representation.OrderRecivedToUpdate;

public interface UpdateOrder {
    void update(OrderRecivedToUpdate orderRecivedToUpdate);
}
