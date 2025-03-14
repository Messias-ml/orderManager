package messiasproject.microservicespecialist.order.domain.service.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.ItemsOrderRepresention;
import messiasproject.microservicespecialist.order.application.representation.OrderRepresentation;
import messiasproject.microservicespecialist.order.domain.exception.RecordDoesntExist;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.SearchOrderByUuid;
import messiasproject.microservicespecialist.order.infra.openfeign.interfaces.FindAllItemsOrder;
import messiasproject.microservicespecialist.order.infra.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchOrderByUuidImplementation implements SearchOrderByUuid {

    private final OrderRepository repository;
    private final FindAllItemsOrder findAllItemsOrder;

    @Override
    public OrderRepresentation search(String uuid) {
        OrderEntity orderEntity = repository.findByUuid(uuid).orElseThrow(() -> new RecordDoesntExist(new Object[]{uuid}));
        OrderRepresentation orderRepresentation = new OrderRepresentation();
        orderRepresentation.setUuid(uuid);
        orderRepresentation.setTotalValue(orderEntity.getTotalValue());
        orderRepresentation.setItems(findAllItemsOrder.find(uuid));
        return orderRepresentation;
    }
}
