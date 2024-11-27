package messiasproject.microservicespecialist.order.application.model.DTO;

import lombok.Data;

@Data
public class ItemOrderDTO {
    private Integer count;
    private Double price;
    private Long idProduct;
}
