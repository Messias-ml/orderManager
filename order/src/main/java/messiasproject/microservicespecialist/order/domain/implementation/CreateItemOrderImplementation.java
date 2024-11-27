package messiasproject.microservicespecialist.order.domain.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.ItemOrderDTO;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;
import messiasproject.microservicespecialist.order.domain.model.OrderStatus;
import messiasproject.microservicespecialist.order.domain.model.entity.ItemOrderEntity;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.domain.model.entity.ProductEntity;
import messiasproject.microservicespecialist.order.infra.CreateItemOrder;
import messiasproject.microservicespecialist.order.infra.event.NotifyUpdateOrder;
import messiasproject.microservicespecialist.order.infra.repository.ItemOrderRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class CreateItemOrderImplementation implements CreateItemOrder {

    private final ItemOrderRepository repository;

    private final NotifyUpdateOrder notifyUpdateOrder;

    @Override
    public void createItemOrder(OrderRecivedDTO order) {
        List<ItemOrderEntity> listItemOrderEntity = new ArrayList<>();
        List<ItemOrderDTO> listOrderItem = order.getListOrderItem();
        AtomicReference<Double> valueTotal = new AtomicReference<>(0.0);
        listOrderItem.stream().forEach(item-> {
            ItemOrderEntity itemOrderEntity = new ItemOrderEntity();
            ProductEntity productEntity = new ProductEntity();
            itemOrderEntity.setPrice(item.getPrice());
            itemOrderEntity.setCount(item.getCount());
            valueTotal.set(valueTotal.get() + item.getPrice() * item.getCount());
            productEntity.setId(item.getIdProduct());
            itemOrderEntity.setProduct(productEntity);
            itemOrderEntity.setOrder(order.getOrderEntity());
            ItemOrderEntity itemSaved = repository.save(itemOrderEntity);
            listItemOrderEntity.add(itemSaved);
        });
        OrderEntity orderEntity = order.getOrderEntity();
        orderEntity.insertItems(listItemOrderEntity);
        orderEntity.setTotalValue(valueTotal.get());
        orderEntity.setStatus(OrderStatus.CALCULADO);
        notifyUpdateOrder.eventUpdateOrder(orderEntity);
    }
}
