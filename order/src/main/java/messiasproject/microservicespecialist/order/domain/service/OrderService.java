package messiasproject.microservicespecialist.order.domain.service;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderClientDTO;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;
import messiasproject.microservicespecialist.order.application.model.specification.OrderFilterSpec;
import messiasproject.microservicespecialist.order.domain.model.entity.ItemOrderEntity;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.ReciveOrder;
import messiasproject.microservicespecialist.order.infra.SearchOrderByData;
import messiasproject.microservicespecialist.order.infra.SearchOrderByUuid;
import messiasproject.microservicespecialist.order.infra.repository.ItemOrderRepository;
import messiasproject.microservicespecialist.order.infra.repository.OrderRepository;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    private final ReciveOrder reciveOrder;

    private final ItemOrderRepository itemOrderRepository;

    private final SearchOrderByUuid searchOrderByUuid;

    private final SearchOrderByData searchOrderByData;

    public void reciveOrder(OrderRecivedDTO order) {
        reciveOrder.reciveOrder(order);
    }

    @EventListener
    public void createOrder(OrderEntity orderEntity){
        repository.save(orderEntity);
        repository.flush();
    }

    public OrderEntity findById(Long id) {
        OrderEntity orderEntity = repository.findById(id).get();
        return orderEntity;
    }

    public OrderClientDTO searchOrderByUuid(String uuid) {
        return searchOrderByUuid.search(uuid);
    }

    public List<ItemOrderEntity> findAllItemOrder() {
        List<ItemOrderEntity> all = itemOrderRepository.findAll();
        return all;
    }

    public Page<OrderClientDTO> searchOrderByData(Pageable page, OrderFilterSpec orderFilterSpec) {
        return searchOrderByData.search(page, orderFilterSpec);
    }

    public List<OrderEntity> findAllOrder() {
        List<OrderEntity> all = repository.findAll();
        return all;
    }
}
