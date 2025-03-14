package messiasproject.microservicespecialist.itemorder.application.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class OrderRecivedDTO {

    @Schema(example = "op-1634925MDY", description = "uuid do pedido")
    private String uuid;

    @Schema(description = "Lista de itens do pedido")
    private List<ItemOrderDTO> listOrderItem;
}
