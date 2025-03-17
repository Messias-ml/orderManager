package messiasproject.microservicespecialist.product.infra;

import messiasproject.microservicespecialist.product.application.model.CodeProduct;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;

public interface CreateProduct {

    CodeProduct create(ProductRepresentation product);
}
