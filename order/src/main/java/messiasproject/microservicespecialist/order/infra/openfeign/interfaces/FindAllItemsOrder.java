package messiasproject.microservicespecialist.order.infra.openfeign.interfaces;

import messiasproject.microservicespecialist.order.application.representation.ItemsOrderRepresention;

import java.util.List;

public interface FindAllItemsOrder {
    List<ItemsOrderRepresention> find(String uuidOrder);
}
