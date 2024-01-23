package org.example.product_trial.product.infrastructure.web.controllers;

import org.example.product_trial.product.domain.exceptions.ProductException;
import org.example.product_trial.product.domain.mappers.ProductMapper;
import org.example.product_trial.product.domain.services.ProductService;
import org.example.product_trial.product.infrastructure.web.requests.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ProductRequest productRequest){
        var product = productService.create(productRequest);
        return new ResponseEntity<>(ProductMapper.toResponse(product), HttpStatus.CREATED);
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> getById(@PathVariable Long productId){
        try {
            var productResponse = ProductMapper.toResponse(productService.getById(productId));
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        var productResponses = productService.getAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @PatchMapping("{productId}")
    public ResponseEntity<?> update(@PathVariable Long productId, @RequestBody ProductRequest productRequest){
        try {
            var productResponse = ProductMapper.toResponse(productService.update(productId, productRequest));
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> delete(@PathVariable Long productId){
        try {
            productService.delete(productId);
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
