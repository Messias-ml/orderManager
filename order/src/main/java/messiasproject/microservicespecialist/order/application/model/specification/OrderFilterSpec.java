package messiasproject.microservicespecialist.order.application.model.specification;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class OrderFilterSpec {
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS")
    @Schema(example = "27-11-2024T01:00:00.000", description = "hora que deseja buscar os registros", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    LocalDateTime time;
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS")
    @Schema(example = "27-11-2024T01:00:00.000", description = "hora inicial que deseja buscar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    LocalDateTime initiate;
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS")
    @Schema(example = "27-11-2024T01:00:00.000", description = "hora final que deseja buscar", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    LocalDateTime terminate;
}
