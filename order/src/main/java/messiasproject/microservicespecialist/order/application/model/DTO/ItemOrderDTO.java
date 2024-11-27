package messiasproject.microservicespecialist.order.application.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ItemOrderDTO {

    @Schema(name = "count", description = "quantidade do item do pedido, numero inteiro", example = "2")
    private Integer count;
    @Schema(name = "price", description = "preço do item do pedido, numero decimal", example = "2977.16")
    private Double price;
    @Schema(name = "idProduct", description = "id do produto", example = "1")
    private Long idProduct;
}
