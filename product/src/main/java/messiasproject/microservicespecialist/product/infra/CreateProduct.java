package messiasproject.microservicespecialist.product.infra;

import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;

public interface CreateProduct {

    void create(ProductRepresentation product);
}
