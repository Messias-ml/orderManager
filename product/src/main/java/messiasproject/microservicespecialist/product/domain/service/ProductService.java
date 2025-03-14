package messiasproject.microservicespecialist.product.domain.service;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import messiasproject.microservicespecialist.product.domain.exception.RecordDoesntExist;
import messiasproject.microservicespecialist.product.infra.repository.ProductRepository;
import messiasproject.microservicespecialist.product.domain.model.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public void createProduct(ProductRepresentation product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setUuid(product.getUuid());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        repository.save(productEntity);
    }

    public Page<ProductEntity> findAllProduct(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public ProductRepresentation findByUuid(String uuid){
        ProductEntity productEntity = repository.findByUuid(uuid).orElseThrow(() -> new RecordDoesntExist(new Object[]{uuid}));
        ProductRepresentation productRepresentation = new ProductRepresentation();
        productRepresentation.setName(productEntity.getName());
        productRepresentation.setUuid(uuid);
        productRepresentation.setPrice(productEntity.getPrice());
        return productRepresentation;
    }
}
