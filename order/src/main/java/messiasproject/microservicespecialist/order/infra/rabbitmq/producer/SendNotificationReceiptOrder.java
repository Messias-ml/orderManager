package messiasproject.microservicespecialist.order.infra.rabbitmq.producer;

import messiasproject.microservicespecialist.order.application.representation.ReceivingOrder;

public interface SendNotificationReceiptOrder {
    void send(ReceivingOrder order);
}
