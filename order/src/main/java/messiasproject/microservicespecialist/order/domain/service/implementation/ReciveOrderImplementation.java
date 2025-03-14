package messiasproject.microservicespecialist.order.domain.service.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.CodeOrder;
import messiasproject.microservicespecialist.order.application.representation.ReceivingOrder;
import messiasproject.microservicespecialist.order.domain.exception.ListEmptyException;
import messiasproject.microservicespecialist.order.domain.model.enums.OrderStatus;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.ReciveOrder;
import messiasproject.microservicespecialist.order.infra.rabbitmq.producer.SendNotificationReceiptOrder;
import messiasproject.microservicespecialist.order.infra.repository.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
@RequiredArgsConstructor
public class ReciveOrderImplementation implements ReciveOrder {

    private final OrderRepository repository;
    private final SendNotificationReceiptOrder sendNotificationReceiptOrder;

    @Override
    public CodeOrder reciveOrder(ReceivingOrder order) {
        if (CollectionUtils.isEmpty(order.getListOrderItem())){
            throw new ListEmptyException();
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setStatus(OrderStatus.RECEBIDO);
        OrderEntity orderSaved = repository.save(orderEntity);
        order.setUuid(orderSaved.getUuid());
        sendNotificationReceiptOrder.send(order);
        return new CodeOrder(order.getUuid());
    }
}
