package messiasproject.microservicespecialist.order.application.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ItemsOrderRepresention {
    @Schema(example = "Televisão Sansung 45 polegadas", description = "preço do item do pedido, numero decimal")
    private String productName;
    @Schema(name = "price", description = "preço do item do pedido, numero decimal", example = "2977.16")
    private Double price;
    @Schema(name = "count", description = "quantidade do item do pedido, numero inteiro", example = "2")
    private Integer count;
}
