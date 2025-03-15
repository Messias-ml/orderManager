package messiasproject.microservicespecialist.product.domain.service.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import messiasproject.microservicespecialist.product.domain.model.ProductEntity;
import messiasproject.microservicespecialist.product.infra.CreateProduct;
import messiasproject.microservicespecialist.product.infra.repository.ProductRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateProductImplementation implements CreateProduct {

    private final ProductRepository repository;

    @Override
    public void create(ProductRepresentation product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        repository.save(productEntity);
    }
}
