package messiasproject.microservicespecialist.order.application.representation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ReceivingOrder {

    @Schema(example = "op-1634925MDY", description = "uuid do pedido")
    private String uuid;

    @NotNull(message = "{erro.msg.notNull}")
    @Valid
    @Schema(description = "Lista de itens do pedido")
    private List<ItemOrderDTO> listOrderItem;
}
