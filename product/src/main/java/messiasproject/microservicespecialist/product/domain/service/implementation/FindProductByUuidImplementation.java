package messiasproject.microservicespecialist.product.domain.service.implementation;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import messiasproject.microservicespecialist.product.domain.exception.RecordDoesntExist;
import messiasproject.microservicespecialist.product.domain.model.ProductEntity;
import messiasproject.microservicespecialist.product.infra.FindProductByUuid;
import messiasproject.microservicespecialist.product.infra.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindProductByUuidImplementation implements FindProductByUuid {

    private final ProductRepository repository;

    @Override
    public ProductRepresentation find(String uuid) {
        ProductEntity productEntity = repository.findByUuid(uuid).orElseThrow(() -> new RecordDoesntExist(new Object[]{uuid}));
        ProductRepresentation productRepresentation = new ProductRepresentation();
        productRepresentation.setName(productEntity.getName());
        productRepresentation.setUuid(uuid);
        productRepresentation.setPrice(productEntity.getPrice());
        return productRepresentation;
    }
}
