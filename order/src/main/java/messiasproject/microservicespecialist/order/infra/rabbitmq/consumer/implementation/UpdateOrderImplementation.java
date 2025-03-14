package messiasproject.microservicespecialist.order.infra.rabbitmq.consumer.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.OrderRecivedToUpdate;
import messiasproject.microservicespecialist.order.domain.exception.RecordDoesntExist;
import messiasproject.microservicespecialist.order.domain.model.enums.OrderStatus;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.rabbitmq.consumer.UpdateOrder;
import messiasproject.microservicespecialist.order.infra.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateOrderImplementation implements UpdateOrder {

    private final OrderRepository repository;

    @Override
    public void update(OrderRecivedToUpdate orderRecivedToUpdate) {
        String uuid = orderRecivedToUpdate.getUuid();
        OrderEntity orderEntity = repository.findByUuid(uuid).orElseThrow(() -> new RecordDoesntExist(new Object[]{uuid}));
        orderEntity.setStatus(OrderStatus.CALCULADO);
        orderEntity.setTotalValue(orderRecivedToUpdate.getTotalValue());
        repository.save(orderEntity);
    }
}
