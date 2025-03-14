package messiasproject.microservicespecialist.itemorder.infra;

import messiasproject.microservicespecialist.itemorder.application.model.ItemOrderRepresention;

import java.util.List;

public interface FindAllItemOrder {

    List<ItemOrderRepresention> find(String uuid);
}
