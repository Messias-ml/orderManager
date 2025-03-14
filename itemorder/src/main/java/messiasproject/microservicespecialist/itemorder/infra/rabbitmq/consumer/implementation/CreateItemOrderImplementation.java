package messiasproject.microservicespecialist.itemorder.infra.rabbitmq.consumer.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.itemorder.application.model.ItemOrderDTO;
import messiasproject.microservicespecialist.itemorder.application.model.OrderRecivedDTO;
import messiasproject.microservicespecialist.itemorder.application.model.OrderToUpdateDTO;
import messiasproject.microservicespecialist.itemorder.domain.entity.ItemOrderEntity;
import messiasproject.microservicespecialist.itemorder.infra.rabbitmq.producer.NotifyUpdateOrder;
import messiasproject.microservicespecialist.itemorder.infra.rabbitmq.consumer.CreateItemOrder;
import messiasproject.microservicespecialist.itemorder.infra.repository.ItemOrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class CreateItemOrderImplementation implements CreateItemOrder {

    private final ItemOrderRepository repository;

    private final NotifyUpdateOrder notifyUpdateOrder;

    @Override
    public void create(OrderRecivedDTO order) {
        List<ItemOrderEntity> listItemOrderEntity = new ArrayList<>();
        List<ItemOrderDTO> listOrderItem = order.getListOrderItem();
        AtomicReference<Double> totalValue = new AtomicReference<>(0.0);
        listOrderItem.stream().forEach(item-> {
            ItemOrderEntity itemOrderEntity = new ItemOrderEntity();
            itemOrderEntity.setPrice(item.getPrice());
            itemOrderEntity.setCount(item.getCount());
            itemOrderEntity.setProductName(item.getProductName());
            itemOrderEntity.setUuidOrder(order.getUuid());
            itemOrderEntity.setUuidProduct(item.getUuidProduct());
            totalValue.set(totalValue.get() + item.getPrice() * item.getCount());
            ItemOrderEntity itemSaved = repository.save(itemOrderEntity);
            listItemOrderEntity.add(itemSaved);
        });
        OrderToUpdateDTO orderToUpdateDTO = new OrderToUpdateDTO();
        orderToUpdateDTO.setUuid(order.getUuid());
        orderToUpdateDTO.setTotalValue(totalValue.get());
        notifyUpdateOrder.update(orderToUpdateDTO);
    }
}
