package messiasproject.microservicespecialist.order.domain.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.domain.exception.DuplicateOrder;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;
import messiasproject.microservicespecialist.order.domain.model.OrderStatus;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.ReciveOrder;
import messiasproject.microservicespecialist.order.infra.event.NotifyCreateItem;
import messiasproject.microservicespecialist.order.infra.repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReciveOrderImplementation implements ReciveOrder {
    private final OrderRepository repository;
    private final NotifyCreateItem notifyCreateItem;
    @Override
    public void reciveOrder(OrderRecivedDTO order) {
        Boolean uuidIsPresent = repository.existsByUuid(order.getUuid());
        if(uuidIsPresent){
            throw new DuplicateOrder(new Object[]{order.getUuid()});
        }
        
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUuid(order.getUuid());
        orderEntity.setStatus(OrderStatus.RECEBIDO);
        repository.save(orderEntity);
        repository.flush();
        order.setOrderEntity(orderEntity);
        notifyCreateItem.eventCreateItem(order);
    }
}
