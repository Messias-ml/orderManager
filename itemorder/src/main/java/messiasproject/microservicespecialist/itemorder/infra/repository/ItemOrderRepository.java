package messiasproject.microservicespecialist.itemorder.infra.repository;

import messiasproject.microservicespecialist.itemorder.domain.entity.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, Long> {

    @Query("SELECT io FROM ItemOrderEntity io WHERE io.uuidOrder = :uuidOrder")
    List<ItemOrderEntity> findAllByOrderUuid(String uuidOrder);
}
