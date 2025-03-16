package messiasproject.microservicespecialist.product.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Long id;

    @Column(name = "cod_product", nullable = false, unique = true)
    private String uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @PrePersist
    private void setPrePersist() {
        uuid = "pr-" + UUID.randomUUID().toString().replaceAll("[^a-zA-Z0-9]", "").substring(0, 10);
    }
}
