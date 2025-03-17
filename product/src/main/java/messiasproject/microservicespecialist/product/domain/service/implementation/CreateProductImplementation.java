package messiasproject.microservicespecialist.product.domain.service.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.product.application.model.CodeProduct;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import messiasproject.microservicespecialist.product.domain.model.ProductEntity;
import messiasproject.microservicespecialist.product.infra.CreateProduct;
import messiasproject.microservicespecialist.product.infra.repository.ProductRepository;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateProductImplementation implements CreateProduct {

    private final ProductRepository repository;
    private final CacheManager cacheManager;

    @Override
    public CodeProduct create(ProductRepresentation product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        ProductEntity productSaved = repository.save(productEntity);
        String uuid = productSaved.getUuid();
        CodeProduct codeProduct = new CodeProduct(uuid);
        product.setUuid(uuid);
        cacheManager.getCache("productByUuid").put(codeProduct.getCodProduct(), product);
        return codeProduct;
    }
}
