package messiasproject.microservicespecialist.itemorder.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "item_order")
public class  ItemOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_item", nullable = false)
    private Long id;

    private Integer count;

    private Double price;

    private String uuidOrder;

    private String uuidProduct;

    private String ProductName;
}