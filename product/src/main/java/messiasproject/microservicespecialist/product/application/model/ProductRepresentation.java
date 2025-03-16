package messiasproject.microservicespecialist.product.application.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductRepresentation {

    private String uuid;

    @Size(min = 3, message = "{erro.size}")
    @NotEmpty
    private String name;

    @NotNull
    @Min(value = 1, message = "{erro.min}")
    private Double price;
}