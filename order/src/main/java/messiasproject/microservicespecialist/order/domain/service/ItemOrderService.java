package messiasproject.microservicespecialist.order.domain.service;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;
import messiasproject.microservicespecialist.order.infra.CreateItemOrder;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemOrderService {
    private final CreateItemOrder createItemOrder;

    @EventListener
    public void CreateItemOrder(OrderRecivedDTO order){
        createItemOrder.createItemOrder(order);
    }

}
