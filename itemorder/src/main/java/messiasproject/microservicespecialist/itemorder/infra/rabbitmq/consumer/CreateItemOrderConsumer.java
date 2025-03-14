package messiasproject.microservicespecialist.itemorder.infra.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.itemorder.application.model.OrderRecivedDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateItemOrderConsumer {

    private final CreateItemOrder createItemOrder;

    @RabbitListener(queues = "${queues.recive.order.name}")
    private void createItemOrder(@Payload OrderRecivedDTO order){
        createItemOrder.create(order);
    }
}
