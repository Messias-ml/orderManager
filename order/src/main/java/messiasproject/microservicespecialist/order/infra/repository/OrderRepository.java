package messiasproject.microservicespecialist.order.infra.repository;

import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>, JpaSpecificationExecutor<OrderEntity> {
    Boolean existsByUuid(String uuid);

    @Query("SELECT o FROM OrderEntity o LEFT JOIN FETCH o.items it LEFT JOIN FETCH it.product WHERE o.uuid = :uuid")
    OrderEntity findByUuid(String uuid);

    @Override
    @Query("SELECT o FROM OrderEntity o LEFT JOIN FETCH o.items WHERE o.id = :id")
    Optional<OrderEntity> findById(@Param("id") Long id);
}