package messiasproject.microservicespecialist.order.application.representation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ItemOrderDTO {

    @NotBlank(message = "{erro.msg.notNull}")
    @Schema(name = "productName", description = "uuid do produto", example = "op-1634925MDY")
    private String productName;

    @NotNull(message = "{erro.msg.notNull}")
    @Min(value = 1, message = "{erro.msg.min}")
    @Schema(name = "count", description = "quantidade do item do pedido, numero inteiro", example = "2")
    private Integer count;

    @NotNull(message = "{erro.msg.notNull}")
    @Min(value = 1, message = "{erro.msg.min}")
    @Schema(name = "price", description = "preço do item do pedido, numero decimal", example = "2977.16")
    private Double price;

    @NotBlank(message = "{erro.msg.notNull}")
    @Size(min = 13, max = 13, message = "{erro.msg.uuidProduct}")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "{erro.msg.regex}")
    @Schema(name = "uuidProduct", description = "uuid do produto", example = "op-1634925MDY")
    private String uuidProduct;
}
