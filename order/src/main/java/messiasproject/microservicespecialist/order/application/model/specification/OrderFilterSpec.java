package messiasproject.microservicespecialist.order.application.model.specification;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class OrderFilterSpec {
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS")
    LocalDateTime time;
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS")
    LocalDateTime initiate;
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss.SSS")
    LocalDateTime terminate;
}
