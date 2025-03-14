package messiasproject.microservicespecialist.order.infra;

import messiasproject.microservicespecialist.order.application.representation.CodeOrder;
import messiasproject.microservicespecialist.order.application.representation.ReceivingOrder;

public interface ReciveOrder {
    CodeOrder reciveOrder(ReceivingOrder order);
}
