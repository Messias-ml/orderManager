package messiasproject.microservicespecialist.order.infra.openfeign;

import messiasproject.microservicespecialist.order.application.representation.ItemsOrderRepresention;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "itemOrder", path = "/itemOrder")
public interface ItemOrderController {

    @GetMapping("/{uuid}")
    List<ItemsOrderRepresention> findAllItemOrder(@PathVariable String uuid);
}
