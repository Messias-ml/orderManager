package messiasproject.microservicespecialist.order.infra;

import messiasproject.microservicespecialist.order.application.model.DTO.OrderClientDTO;
import messiasproject.microservicespecialist.order.application.model.specification.OrderFilterSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface SearchOrderByData {
    Page<OrderClientDTO> search(Pageable page, OrderFilterSpec orderFilterSpec);
}
