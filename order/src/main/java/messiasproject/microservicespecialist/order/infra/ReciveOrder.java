package messiasproject.microservicespecialist.order.infra;

import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;

public interface ReciveOrder {
    void reciveOrder(OrderRecivedDTO order);
}
