package org.example.product_trial.product.infrastructure.web.requests;

public class ProductRequest {
    public String code;
    public String name;
    public String description;
    public String image;
    public Double price;
    public String category;
    public Integer quantity;
    public String inventoryStatus;
    public Integer rating;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public Integer getRating() {
        return rating;
    }
}
