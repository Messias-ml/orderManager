package messiasproject.microservicespecialist.product.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.product.application.model.ProductRepresentation;
import messiasproject.microservicespecialist.product.domain.model.ProductEntity;
import messiasproject.microservicespecialist.product.domain.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "Api de produtos")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid ProductRepresentation product){
        service.createProduct(product);
    }

    @GetMapping
    public Page<ProductEntity> findAllProduct(@PageableDefault(sort = "name",
            direction = Sort.Direction.DESC) Pageable pageable) {
        return service.findAllProduct(pageable);
    }

    @GetMapping("/{uuid}")
    public ProductRepresentation findByUuid(@PathVariable String uuid) {
        return service.findByUuid(uuid);
    }
}