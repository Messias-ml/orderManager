package messiasproject.microservicespecialist.order.domain.service;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.ProductDTO;
import messiasproject.microservicespecialist.order.domain.model.entity.ProductEntity;
import messiasproject.microservicespecialist.order.infra.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    public void createProduct(ProductDTO product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        repository.save(productEntity);
    }

    public List<ProductEntity> findAllProduct() {
        return repository.findAll();
    }
}
