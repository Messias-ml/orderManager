package messiasproject.microservicespecialist.product.infra;

import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllProduct {

    Page<ProductRepresentation> find(Pageable pageable);
}
