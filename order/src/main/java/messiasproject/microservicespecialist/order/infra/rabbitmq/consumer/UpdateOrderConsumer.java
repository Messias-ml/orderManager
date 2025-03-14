package messiasproject.microservicespecialist.order.infra.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.OrderRecivedToUpdate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateOrderConsumer {

    private final UpdateOrder updateOrder;

    @RabbitListener(queues = "${queues.notify.update.order.name}")
    public void updateOrder(@Payload OrderRecivedToUpdate orderRecivedToUpdate){
        updateOrder.update(orderRecivedToUpdate);
    }
}
