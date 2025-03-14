package messiasproject.microservicespecialist.order.infra.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PageOpenApi {
    @Schema(name = "page", description = "numero da pagina que deseja buscar", example = "2")
    private Integer page;
    @Schema(name = "size", description = "quantos conteudos deseja que seja trago na pagina", example = "10")
    private Integer size;
    @Schema(name = "sort", description = "ordenamento da pagina", example = "sort=dataInclusao,asc")
    private String sort;
}
