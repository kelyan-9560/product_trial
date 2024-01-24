package org.example.product_trial.product.infrastructure.web.responses;

public class ProductResponse {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private Double price;
    private String category;
    private Integer quantity;
    private String inventoryStatus;
    private Integer rating;

    
    public Long getId() {
        return id;
    }

    public ProductResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ProductResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductResponse setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ProductResponse setImage(String image) {
        this.image = image;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductResponse setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductResponse setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductResponse setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public ProductResponse setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public ProductResponse setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}
