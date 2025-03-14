package messiasproject.microservicespecialist.itemorder.infra.rabbitmq.consumer;

import messiasproject.microservicespecialist.itemorder.application.model.OrderRecivedDTO;

public interface CreateItemOrder {

    void create(OrderRecivedDTO order);
}
