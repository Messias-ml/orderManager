package messiasproject.microservicespecialist.order.application.model.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    @NotNull
    private String name;
    @NotNull
    private Double price;

}
