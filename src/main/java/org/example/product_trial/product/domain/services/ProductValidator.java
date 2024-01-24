package org.example.product_trial.product.domain.services;

import org.example.product_trial.product.domain.entities.Product;
import org.example.product_trial.product.domain.exceptions.ProductException;
import org.springframework.stereotype.Service;

@Service
public class ProductValidator {
    
    private void validateCode(String code){
        if (code == null || code.isEmpty()){
            throw new ProductException("Code is not valid");
        }
    }
    
    private void validateName(String name){
        if (name == null || name.isEmpty()){
            throw new ProductException("Name is not valid");
        }
    }
    
    private void validateDescription(String description){
        if (description == null || description.isEmpty()){
            throw new ProductException("Description is not valid");
        }
    }

    
    private void validatePrice(Double price){
        if (price == null || price < 0){
            throw new ProductException("Price is not valid");
        }
    }
    
    private void validateCategory(String category){
        if (category == null || category.isEmpty()){
            throw new ProductException("Category is not valid");
        }
    }
    
    private void validateQuantity(Integer quantity){
        if (quantity == null || quantity < 0){
            throw new ProductException("Quantity is not valid");
        }
    }
    
    private void validateInventoryStatus(String inventoryStatus){
        if (inventoryStatus == null || inventoryStatus.isEmpty()){
            throw new ProductException("InventoryStatus is not valid");
        }
    }
    
    private void validateRating(Integer rating){
        if (rating != null && rating < 0){
            throw new ProductException("Rating is not valid");
        }
    }

    public void validateProduct(Product product){
        validateCode(product.getCode());
        validateName(product.getName());
        validateDescription(product.getDescription());
        validatePrice(product.getPrice());
        validateCategory(product.getCategory());
        validateQuantity(product.getQuantity());
        validateInventoryStatus(product.getInventoryStatus());
        validateRating(product.getRating());
    }
    
    
}
