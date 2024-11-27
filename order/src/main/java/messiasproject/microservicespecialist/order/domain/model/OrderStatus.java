package messiasproject.microservicespecialist.order.domain.model;

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
