package messiasproject.microservicespecialist.order.application.controller;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderClientDTO;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;
import messiasproject.microservicespecialist.order.application.model.specification.OrderFilterSpec;
import messiasproject.microservicespecialist.order.domain.model.entity.ItemOrderEntity;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.domain.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void reciveOrder(@RequestBody OrderRecivedDTO order){
        service.reciveOrder(order);
    }

    @GetMapping("/teste")
    public OrderEntity findById(@RequestParam Long id){
        return service.findById(id);
    }


    @GetMapping("/{uuid}")
    public OrderClientDTO searchOrderByUuid(@PathVariable String uuid){
        return service.searchOrderByUuid(uuid);
    }

    @GetMapping
    public Page<OrderClientDTO> searchOrderByData(@PageableDefault(sort = "dateCreation",
            direction = Sort.Direction.DESC) Pageable page, OrderFilterSpec orderFilterSpec){
        return service.searchOrderByData(page, orderFilterSpec);
    }
    @GetMapping("/teste1")
    public List<OrderEntity> orderEntities(){
        return service.findAllOrder();
    }

    @GetMapping("item/{uuid}")
    public List<ItemOrderEntity> findAllItemOrder(){
        return service.findAllItemOrder();
    }

}
