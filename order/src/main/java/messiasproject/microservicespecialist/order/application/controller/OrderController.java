package messiasproject.microservicespecialist.order.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.CodeOrder;
import messiasproject.microservicespecialist.order.application.representation.OrderRepresentation;
import messiasproject.microservicespecialist.order.application.representation.ReceivingOrder;
import messiasproject.microservicespecialist.order.application.representation.specification.OrderFilterSpec;
import messiasproject.microservicespecialist.order.infra.documentation.OrderOpenApi;
import messiasproject.microservicespecialist.order.domain.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name = "Order", description = "Api que controla os pedidos")
public class OrderController implements OrderOpenApi {

    private final OrderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CodeOrder reciveOrder(@RequestBody @Valid ReceivingOrder order){
        return service.reciveOrder(order);
    }

    @GetMapping("/{uuid}")
    public OrderRepresentation searchOrderByUuid(@PathVariable("uuid") String uuid){
        return service.searchOrderByUuid(uuid);
    }

    @GetMapping
    public Page<OrderRepresentation> searchOrderByData(@PageableDefault(sort = "dateCreation",
            direction = Sort.Direction.DESC, size = 5) Pageable page, OrderFilterSpec orderFilterSpec){
        return service.searchOrderByData(page, orderFilterSpec);
    }
}
