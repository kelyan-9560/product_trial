package org.example.product_trial.product.domain.mappers;

import org.example.product_trial.product.domain.entities.Product;
import org.example.product_trial.product.infrastructure.web.requests.ProductRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    @Test
    @DisplayName("Should map a product to a product response")
    void toResponse() {
        var product = new Product()
                .setId(1L)
                .setCode("azerty")
                .setName("productTest")
                .setPrice(24.0);

        var productResponse = ProductMapper.toResponse(product);

        assertEquals(1L, productResponse.getId());
    }

    @Test
    @DisplayName("Should map a product request to a product entity")
    void toEntity() {
        var productRequest = new ProductRequest()
                .setCode("azerty")
                .setName("productTest")
                .setPrice(24.0);

        var product = ProductMapper.toEntity(productRequest);

        assertEquals("azerty", product.getCode());
        assertEquals("productTest", product.getName());
        assertEquals(24.0, product.getPrice());
    }
}