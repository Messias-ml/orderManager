package messiasproject.microservicespecialist.order.application.controller;

import lombok.RequiredArgsConstructor;
import messiasproject.microservicespecialist.order.application.model.DTO.ProductDTO;
import messiasproject.microservicespecialist.order.domain.model.entity.ProductEntity;
import messiasproject.microservicespecialist.order.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO product){
        service.createProduct(product);
    }

    @GetMapping
    public List<ProductEntity> findAllProduct(){
        return service.findAllProduct();
    }
}
