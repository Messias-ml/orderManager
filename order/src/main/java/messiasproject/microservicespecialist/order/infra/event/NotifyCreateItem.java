package messiasproject.microservicespecialist.order.infra.event;

import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;

public interface NotifyCreateItem {
    void eventCreateItem(OrderRecivedDTO order);
}
