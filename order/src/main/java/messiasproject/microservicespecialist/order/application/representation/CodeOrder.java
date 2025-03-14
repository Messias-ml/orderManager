package messiasproject.microservicespecialist.order.application.representation;

import lombok.Data;

@Data
public class CodeOrder {

    private String codeOrder;

    public CodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }
}
