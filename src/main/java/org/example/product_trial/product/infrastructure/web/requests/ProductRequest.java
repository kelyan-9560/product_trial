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

    public ProductRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ProductRequest setImage(String image) {
        this.image = image;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductRequest setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductRequest setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductRequest setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public ProductRequest setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public ProductRequest setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}
