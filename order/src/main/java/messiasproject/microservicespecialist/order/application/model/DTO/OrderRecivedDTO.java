package messiasproject.microservicespecialist.order.application.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import messiasproject.microservicespecialist.order.domain.model.entity.OrderEntity;

import java.util.List;

@Data
public class OrderRecivedDTO {

    @NotNull
    private String uuid;

    @NotNull
    private List<ItemOrderDTO> listOrderItem;


    @JsonIgnore
    private OrderEntity orderEntity;
}
