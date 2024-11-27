package messiasproject.microservicespecialist.order.application.model.DTO;

import lombok.Data;

@Data
public class ItemsOrderRepresention {
    private String productName;
    private Double price;
    private Integer count;
}
