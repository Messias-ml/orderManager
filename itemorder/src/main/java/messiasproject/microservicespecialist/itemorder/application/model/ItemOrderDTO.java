package messiasproject.microservicespecialist.itemorder.application.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ItemOrderDTO {

    @Schema(name = "productName", description = "uuid do produto", example = "op-1634925MDY")
    private String productName;

    @Schema(name = "count", description = "quantidade do item do pedido, numero inteiro", example = "2")
    private Integer count;

    @Schema(name = "price", description = "preço do item do pedido, numero decimal", example = "2977.16")
    private Double price;

    @Schema(name = "uuidProduct", description = "uuid do produto", example = "pt-1634925MDY")
    private String uuidProduct;
}