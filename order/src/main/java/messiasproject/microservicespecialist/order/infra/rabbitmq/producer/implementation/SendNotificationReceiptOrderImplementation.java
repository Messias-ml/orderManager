package messiasproject.microservicespecialist.order.infra.rabbitmq.producer.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.ReceivingOrder;
import messiasproject.microservicespecialist.order.infra.rabbitmq.producer.SendNotificationReceiptOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SendNotificationReceiptOrderImplementation implements SendNotificationReceiptOrder {

    private final RabbitTemplate rabbitTemplate;

    @Value("${exchange.recive.order.name}")
    private String reciveOrderExchange;

    @Override
    public void send(ReceivingOrder order) {
        rabbitTemplate.convertAndSend(reciveOrderExchange,"", order);
    }
}
