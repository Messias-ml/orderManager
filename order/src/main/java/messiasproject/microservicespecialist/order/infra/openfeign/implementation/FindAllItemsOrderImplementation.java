package messiasproject.microservicespecialist.order.infra.openfeign.implementation;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.ItemsOrderRepresention;
import messiasproject.microservicespecialist.order.domain.exception.RecordDoesntExist;
import messiasproject.microservicespecialist.order.infra.openfeign.ItemOrderController;
import messiasproject.microservicespecialist.order.infra.openfeign.interfaces.FindAllItemsOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllItemsOrderImplementation implements FindAllItemsOrder {

    private final ItemOrderController itemOrderController;

    @Override
    public List<ItemsOrderRepresention> find(String uuidOrder) {
        try {
            return itemOrderController.findAllItemOrder(uuidOrder);
        } catch (FeignException ex){
            throw new RecordDoesntExist(new Object[]{uuidOrder});
        }
    }
}
