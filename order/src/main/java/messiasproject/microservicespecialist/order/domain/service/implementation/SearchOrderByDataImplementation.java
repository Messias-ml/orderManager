package messiasproject.microservicespecialist.order.domain.service.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.OrderRepresentation;
import messiasproject.microservicespecialist.order.application.representation.specification.OrderFilterSpec;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import messiasproject.microservicespecialist.order.infra.SearchOrderByData;
import messiasproject.microservicespecialist.order.infra.repository.OrderRepository;
import messiasproject.microservicespecialist.order.infra.specification.OrderSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

import static messiasproject.microservicespecialist.order.config.util.modelmapper.ModelMapperConvert.convertList;

@Component
@RequiredArgsConstructor
public class SearchOrderByDataImplementation implements SearchOrderByData {

    private final OrderRepository repository;

    @Override
    public Page<OrderRepresentation> search(Pageable page, OrderFilterSpec orderFilterSpec) {
        OrderSpecification orderSpecification = new OrderSpecification(orderFilterSpec);
        List<OrderEntity> contents = repository.findAll(orderSpecification, page).getContent();
        List<OrderRepresentation> listOrderRepresentations = convertList(contents, OrderRepresentation.class);
        return new PageImpl<>(listOrderRepresentations, page, listOrderRepresentations.size());
    }
}
