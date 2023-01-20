package me.leel.productservice.controller;

import lombok.RequiredArgsConstructor;
import me.leel.productservice.dto.ProductRequest;
import me.leel.productservice.dto.ProductResponse;
import me.leel.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct() {
        return productService.getAllProduct();
    }
}
