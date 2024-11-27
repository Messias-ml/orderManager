package messiasproject.microservicespecialist.order.domain.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.ItemsOrderRepresention;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderClientDTO;
import messiasproject.microservicespecialist.order.domain.model.entity.ItemOrderEntity;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.SearchOrderByUuid;
import messiasproject.microservicespecialist.order.infra.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchOrderByUuidImplementation implements SearchOrderByUuid {
    private final OrderRepository repository;

    @Override
    public OrderClientDTO search(String uuid) {
        OrderEntity orderEntity = repository.findByUuid(uuid);
        OrderClientDTO orderClientDTO = new OrderClientDTO();
        orderClientDTO.setUuid(orderEntity.getUuid());
        orderClientDTO.setTotalValue(orderEntity.getTotalValue());
        orderClientDTO.setItems(convertItemOrderEntityToRepresentation(orderEntity.getItems(), orderClientDTO.getItems()));
        return orderClientDTO;
    }
    private static List<ItemsOrderRepresention> convertItemOrderEntityToRepresentation(List<ItemOrderEntity> itemsEntity, List<ItemsOrderRepresention> itemsRepresention) {
        itemsEntity.forEach(i -> {
            ItemsOrderRepresention itemRepresentationAux = new ItemsOrderRepresention();
            itemRepresentationAux.setCount(i.getCount());
            itemRepresentationAux.setProductName(i.getProduct().getName());
            itemRepresentationAux.setPrice(i.getPrice());
            itemsRepresention.add(itemRepresentationAux);
        });
        return itemsRepresention;
    }
}
