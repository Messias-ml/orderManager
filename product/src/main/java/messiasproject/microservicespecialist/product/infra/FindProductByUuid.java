package messiasproject.microservicespecialist.product.infra;

import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;

public interface FindProductByUuid {
    
    ProductRepresentation find(String uuid);
}
