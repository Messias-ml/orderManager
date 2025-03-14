package messiasproject.microservicespecialist.itemorder.application.handler;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Detalhes do problema de erro")
public class Problem {
    @Schema(example = "400", description = "status http do erro")
    private Integer status;
    @Schema(example = "Registro não existente", description = "titulo do erro")
    private String title;

    @Schema(example = "O registro com o codigo op-234tr não existe no banco de dados.", description = "detalhe para o consumidor sobre o erro")
    private String detail;

    @Schema(example = "O Pedido que você buscou não existe", description = "detalhe para o usurio sobre o erro")
    private String messageUser;

    public Problem(Problem problem) {
        this.status = problem.getStatus();
        this.title = problem.getTitle();
        this.detail = problem.getDetail();
        this.messageUser = problem.getMessageUser();
    }
}
