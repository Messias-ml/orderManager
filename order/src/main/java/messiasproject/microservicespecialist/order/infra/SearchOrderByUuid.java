package messiasproject.microservicespecialist.order.infra;

import messiasproject.microservicespecialist.order.application.representation.OrderRepresentation;

public interface SearchOrderByUuid {
    OrderRepresentation search(String uuid);
}
