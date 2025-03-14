package messiasproject.microservicespecialist.itemorder.infra.rabbitmq.producer;

import messiasproject.microservicespecialist.itemorder.application.model.OrderToUpdateDTO;

public interface NotifyUpdateOrder {

    void update(OrderToUpdateDTO valueTotal);
}
