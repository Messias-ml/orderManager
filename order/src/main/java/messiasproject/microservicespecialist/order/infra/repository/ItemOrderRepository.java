package messiasproject.microservicespecialist.order.infra.repository;

import messiasproject.microservicespecialist.order.domain.model.entity.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, Long> {
}
