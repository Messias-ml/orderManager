package messiasproject.microservicespecialist.itemorder.domain.service.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.itemorder.application.model.ItemOrderRepresention;
import messiasproject.microservicespecialist.itemorder.domain.entity.ItemOrderEntity;
import messiasproject.microservicespecialist.itemorder.domain.exception.RecordDoesntExist;
import messiasproject.microservicespecialist.itemorder.infra.FindAllItemOrder;
import messiasproject.microservicespecialist.itemorder.infra.repository.ItemOrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllItemOrderImplementation implements FindAllItemOrder {

    private final ItemOrderRepository repository;

    @Override
    public List<ItemOrderRepresention> find(String uuidOrder) {
        List<ItemOrderRepresention> listItemOrderRepresentation = new ArrayList<>();
        List<ItemOrderEntity> listItemOrderEntity = repository.findAllByOrderUuid(uuidOrder);
        if (listItemOrderEntity.isEmpty()){
            throw new RecordDoesntExist(new Object[]{uuidOrder});
        }
        listItemOrderEntity.forEach(itemOrder -> {
            ItemOrderRepresention itemOrderRepresention = new ItemOrderRepresention();
            itemOrderRepresention.setProductName(itemOrder.getProductName());
            itemOrderRepresention.setCount(itemOrder.getCount());
            itemOrderRepresention.setUnitaryPrice(itemOrder.getPrice());
            listItemOrderRepresentation.add(itemOrderRepresention);
        });
        return listItemOrderRepresentation;
    }
}
