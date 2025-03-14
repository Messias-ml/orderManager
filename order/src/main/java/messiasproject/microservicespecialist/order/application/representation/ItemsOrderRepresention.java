package messiasproject.microservicespecialist.order.application.representation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ItemsOrderRepresention {

    @Schema(example = "Televisão Sansung 45 polegadas", description = "preço do item do pedido, numero decimal")
    private String productName;

    @Schema(name = "unitaryPrice", description = "preço do item do pedido, numero decimal", example = "2977.16")
    private Double unitaryPrice;

    @Schema(name = "count", description = "quantidade do item do pedido, numero inteiro", example = "2")
    private Integer count;
}
