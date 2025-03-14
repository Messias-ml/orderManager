package messiasproject.microservicespecialist.itemorder.infra.rabbitmq.producer.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.itemorder.application.model.OrderToUpdateDTO;
import messiasproject.microservicespecialist.itemorder.infra.rabbitmq.producer.NotifyUpdateOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotifyUpdateOrderImplementation implements NotifyUpdateOrder {

    private final RabbitTemplate rabbitTemplate;

    @Value("${queues.notify.update.order.name}")
    private String notifyUpdateOrder;

    @Override
    public void update(OrderToUpdateDTO orderToUpdate) {
        rabbitTemplate.convertAndSend(notifyUpdateOrder, orderToUpdate);
    }
}
