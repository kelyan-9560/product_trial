package org.example.product_trial.product.domain.services;

import org.example.product_trial.product.domain.entities.Product;
import org.example.product_trial.product.domain.exceptions.ProductException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidatorTest {

    ProductValidator productValidator = new ProductValidator();

    Product product = new Product()
            .setCode("code")
            .setName("name")
            .setDescription("description")
            .setPrice(1.0)
            .setCategory("category")
            .setQuantity(1)
            .setInventoryStatus("inventoryStatus")
            .setRating(1);


    @Test
    @DisplayName("Should not throw exception when product is valid")
    void validate_product() {
        assertDoesNotThrow(() -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when code is null")
    void validate_product_code() {
        product.setCode(null);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when name is null")
    void validate_product_name() {
        product.setName(null);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when description is null")
    void validate_product_description() {
        product.setDescription(null);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when price is null")
    void validate_product_price() {
        product.setPrice(null);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when category is null")
    void validate_product_category() {
        product.setCategory(null);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when quantity is null")
    void validate_product_quantity() {
        product.setQuantity(null);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when quantity is less than 0")
    void validate_product_quantity_value() {
        product.setQuantity(-2);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }

    @Test
    @DisplayName("Should throw exception when inventoryStatus is null")
    void validate_product_inventoryStatus() {
        product.setInventoryStatus(null);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }


    @Test
    @DisplayName("Should throw exception when rating is less than 0")
    void validate_product_rating_value() {
        product.setRating(-2);
        assertThrows(ProductException.class, () -> productValidator.validateProduct(product));
    }
}