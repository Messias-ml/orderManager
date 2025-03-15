package messiasproject.microservicespecialist.product.application.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRepresentation {

    private String uuid;

    @Min(3)
    @NotEmpty
    private String name;

    @NotNull
    @Min(1)
    private Double price;
}