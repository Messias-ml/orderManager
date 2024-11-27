package messiasproject.microservicespecialist.order.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import messiasproject.microservicespecialist.order.domain.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.*;

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
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ItemOrderEntity> items = new ArrayList<>();

    @Column(name = "total_value", scale = 2)
    private Double totalValue;

    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @PrePersist
    private void setDateCreation(){
        dateCreation = LocalDateTime.now();
    }

    public void insertItems(List<ItemOrderEntity> items){
        this.items.clear();
        this.items.addAll(items);
    }
}
