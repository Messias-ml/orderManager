package messiasproject.microservicespecialist.order.application.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;

import java.util.List;

@Data
public class OrderRecivedDTO {

    @NotNull
    @Schema(example = "op-234tr", description = "uuid do pedido")
    private String uuid;

    @NotNull
    @Schema(description = "Lista de itens do pedido")
    private List<ItemOrderDTO> listOrderItem;


    @JsonIgnore
    private OrderEntity orderEntity;
}
