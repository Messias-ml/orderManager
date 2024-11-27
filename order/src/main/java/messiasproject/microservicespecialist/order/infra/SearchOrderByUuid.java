package messiasproject.microservicespecialist.order.infra;

import messiasproject.microservicespecialist.order.application.model.DTO.OrderClientDTO;

public interface SearchOrderByUuid {
    OrderClientDTO search(String uuid);
}
