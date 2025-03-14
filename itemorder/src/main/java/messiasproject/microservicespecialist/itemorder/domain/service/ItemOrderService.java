package messiasproject.microservicespecialist.itemorder.domain.service;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.itemorder.application.model.ItemOrderRepresention;
import messiasproject.microservicespecialist.itemorder.infra.FindAllItemOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemOrderService {

    private final FindAllItemOrder findAllItemOrder;

    public List<ItemOrderRepresention> findAllItemOrder(String uuid) {
        return findAllItemOrder.find(uuid);
    }
}
