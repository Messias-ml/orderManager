package messiasproject.microservicespecialist.order.application.representation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderRecivedToUpdate {

    @Schema(example = "op-1634925MDY", description = "uuid do pedido")
    private String uuid;

    private Double totalValue;
}
