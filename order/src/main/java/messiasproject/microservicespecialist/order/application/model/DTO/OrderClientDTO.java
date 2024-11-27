package messiasproject.microservicespecialist.order.application.model.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderClientDTO {

    private String uuid;
    private List<ItemsOrderRepresention> items = new ArrayList<>();
    private Double totalValue;
}
