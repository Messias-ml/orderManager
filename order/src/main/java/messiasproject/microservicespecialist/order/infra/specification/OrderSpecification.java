package messiasproject.microservicespecialist.order.infra.specification;

import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import messiasproject.microservicespecialist.order.application.representation.specification.OrderFilterSpec;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OrderSpecification implements Specification<OrderEntity> {

    private OrderFilterSpec time;
    @Override
    public Predicate toPredicate(Root<OrderEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (query.getResultType() != Long.class) {
            Fetch<Object, Object> itemsFetch = root.fetch("items", JoinType.LEFT);
            itemsFetch.fetch("product", JoinType.LEFT);
            query.distinct(true);
        }

        List<Predicate> predicates = new ArrayList<>();
        if (null != time){
            if (time.getTime() != null){
            predicates.add(criteriaBuilder.between(root.get("dateCreation"), time.getTime(), time.getTime().plusMinutes(59L)));
            } else if (time.getInitiate() != null && time.getTerminate() != null) {
                predicates.add(criteriaBuilder.between(root.get("dateCreation"), time.getInitiate(), time.getTerminate()));
            }
        }
        Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
        return criteriaBuilder.and(predicatesArray);
    }
}
