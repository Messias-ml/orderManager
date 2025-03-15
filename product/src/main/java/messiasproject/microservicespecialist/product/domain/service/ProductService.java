package messiasproject.microservicespecialist.product.domain.service;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import messiasproject.microservicespecialist.product.domain.exception.RecordDoesntExist;
import messiasproject.microservicespecialist.product.infra.CreateProduct;
import messiasproject.microservicespecialist.product.infra.FindAllProduct;
import messiasproject.microservicespecialist.product.infra.FindProductByUuid;
import messiasproject.microservicespecialist.product.infra.repository.ProductRepository;
import messiasproject.microservicespecialist.product.domain.model.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final CreateProduct createProduct;
    private final FindAllProduct findAllProduct;
    private final FindProductByUuid findProductByUuid;

    public void createProduct(ProductRepresentation product) {
        createProduct.create(product);
    }

    public Page<ProductRepresentation> findAllProduct(Pageable pageable) {
        return findAllProduct.find(pageable);
    }

    public ProductRepresentation findByUuid(String uuid){
        return findProductByUuid.find(uuid);
    }
}
