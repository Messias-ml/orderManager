package messiasproject.microservicespecialist.itemorder.application.controller;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.itemorder.application.model.ItemOrderRepresention;
import messiasproject.microservicespecialist.itemorder.domain.service.ItemOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemOrder")
@RequiredArgsConstructor
public class ItemOrderController {

    private final ItemOrderService service;

    @GetMapping("/{uuid}")
    public List<ItemOrderRepresention> findAllItemOrder(@PathVariable String uuid){
        return service.findAllItemOrder(uuid);
    }
}
