package messiasproject.microservicespecialist.order.application.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderClientDTO {

    @Schema(example = "op-234tr", description = "uuid do pedido")
    private String uuid;
    @Schema(description = "Lista de itens do pedido")
    private List<ItemsOrderRepresention> items = new ArrayList<>();
    @Schema(example = "5954.32", description = "Valor total do pedido")
    private Double totalValue;
}
