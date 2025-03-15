package messiasproject.microservicespecialist.product.domain.service.implementation;


import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import messiasproject.microservicespecialist.product.config.util.modelmapper.ModelMapperConvert;
import messiasproject.microservicespecialist.product.domain.model.ProductEntity;
import messiasproject.microservicespecialist.product.infra.FindAllProduct;
import messiasproject.microservicespecialist.product.infra.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

import static messiasproject.microservicespecialist.product.config.util.modelmapper.ModelMapperConvert.convertList;

@Component
@RequiredArgsConstructor
public class FindAllProductImplementation implements FindAllProduct {

    private final ProductRepository repository;

    @Override
    public Page<ProductRepresentation> find(Pageable pageable) {
        Page<ProductEntity> pageProductEntity = repository.findAll(pageable);
        List<ProductRepresentation> listProductRepresentation = convertList(pageProductEntity.getContent(), ProductRepresentation.class);
        return new PageImpl<>(listProductRepresentation, pageable, listProductRepresentation.size());
    }
}
