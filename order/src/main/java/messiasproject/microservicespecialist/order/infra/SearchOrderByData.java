package messiasproject.microservicespecialist.order.infra;

import messiasproject.microservicespecialist.order.application.representation.OrderRepresentation;
import messiasproject.microservicespecialist.order.application.representation.specification.OrderFilterSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchOrderByData {
    Page<OrderRepresentation> search(Pageable page, OrderFilterSpec orderFilterSpec);
}
