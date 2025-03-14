package messiasproject.microservicespecialist.order.domain.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import messiasproject.microservicespecialist.order.domain.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_tb")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long id;

    @Column(name = "cod_id", nullable = false, unique = true)
    private String uuid;

    @Column(name = "total_value", scale = 2)
    private Double totalValue;

    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @PrePersist
    private void setPrePersist(){
        uuid = "or-" + UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "").substring(0, 10);
        dateCreation = LocalDateTime.now();
    }
}
