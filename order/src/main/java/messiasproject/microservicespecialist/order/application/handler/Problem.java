package messiasproject.microservicespecialist.order.application.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
    @ApiModelProperty(example = "400")
    private Integer status;
    @ApiModelProperty(example = "faltou um atributo para ser preenchido")
    private String title;

    @ApiModelProperty(example = "O atributo X precisa ser preenchido com um Interger para ser valido.")
    private String detail;

    @ApiModelProperty(example = "O campo idade precisa ser preenchido com um numero e não como uma frase")
    private String messageUser;

    public Problem(Problem problem) {
        this.status = problem.getStatus();
        this.title = problem.getTitle();
        this.detail = problem.getDetail();
        this.messageUser = problem.getMessageUser();
    }
}
