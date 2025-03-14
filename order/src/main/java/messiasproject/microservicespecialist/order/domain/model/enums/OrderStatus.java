package messiasproject.microservicespecialist.order.domain.model.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {

    RECEBIDO("Recebido"),
    CALCULADO("Calculado"),
    ENVIADO("Enviado");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
}
