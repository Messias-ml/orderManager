package messiasproject.microservicespecialist.order.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Product", description = "Api de TESTE apenas para facilitar a inclusão de pedidos para testes do sistema")
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
