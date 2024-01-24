package org.example.product_trial.product.domain.services;

import org.example.product_trial.product.domain.entities.Product;
import org.example.product_trial.product.domain.exceptions.ProductException;
import org.example.product_trial.product.infrastructure.repositories.ProductRepository;
import org.example.product_trial.product.infrastructure.web.requests.ProductRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product()
                .setCode("azerty")
                .setName("productTest")
                .setPrice(24.0);
    }

    @Test
    @DisplayName("Should create a product from a product request")
    void create() {
        var productRequest = new ProductRequest()
                .setCode("azerty")
                .setName("productTest")
                .setPrice(24.0);


        when(productRepository.save(product)).thenReturn(product);

        var productCreated = productService.create(productRequest);

        assertEquals("azerty", productCreated.getCode());
        assertEquals("productTest", productCreated.getName());
        assertEquals(24.0, productCreated.getPrice());
    }

    @Test
    @DisplayName("Should return a product by id")
    void getById() {
        product.setId(1L);

        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));

        var productFound = productService.getById(1L);

        assertEquals(1L, productFound.getId());
        assertEquals("azerty", productFound.getCode());
        assertEquals("productTest", productFound.getName());
        assertEquals(24.0, productFound.getPrice());
    }

    @Test
    @DisplayName("Should throw exception when product not found")
    void should_throw_exception_when_product_not_found() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ProductException.class, () -> productService.getById(1L));
    }

    @Test
    @DisplayName("Should return a list with all products")
    void should_get_all_product() {
        var productList = List.of(
                new Product().setCode("PRODUCT-1"),
                new Product().setCode("PRODUCT-2"),
                new Product().setCode("PRODUCT-3")
        );

        when(productRepository.findAll()).thenReturn(productList);

        var productListFound = productService.getAll();
        assertEquals(3, productListFound.size());
    }

    @Test
    void update() {
        when(productRepository.findById(1L)).thenReturn(Optional.ofNullable(product));

        var update = new Product()
                .setCode("code updated")
                .setName("name updated")
                .setPrice(256.0);
        when(productRepository.save(update)).thenReturn(update);


        var productRequest = new ProductRequest()
                .setCode("code updated")
                .setName("name updated")
                .setPrice(256.0);
        var productUpdated = productService.update(1L, productRequest);


        assertEquals("code updated", productUpdated.getCode());
        assertEquals("name updated", productUpdated.getName());
        assertEquals(256.0, productUpdated.getPrice());
    }

    @Test
    @DisplayName("Should delete a product")
    void delete() {
        var productList = List.of(
                new Product().setId(2L).setCode("PRODUCT-2"),
                new Product().setId(3L).setCode("PRODUCT-3"),
                new Product().setId(4L).setCode("PRODUCT-4")
        );

        when(productRepository.findById(3L)).thenReturn(Optional.ofNullable(productList.get(2)));
        productService.delete(3L);


        var productListAfterDeletion = List.of(
                new Product().setId(2L).setCode("PRODUCT-2"),
                new Product().setId(3L).setCode("PRODUCT-3")
        );
        when(productRepository.findAll()).thenReturn(productListAfterDeletion);


        var productListFound = productService.getAll();
        assertEquals(2, productListFound.size());
    }
}