package org.example.product_trial.product.domain.mappers;

import org.example.product_trial.product.domain.entities.Product;
import org.example.product_trial.product.infrastructure.web.requests.ProductRequest;
import org.example.product_trial.product.infrastructure.web.responses.ProductResponse;

public class ProductMapper {

    public static ProductResponse toResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getImage(),
                product.getPrice(),
                product.getCategory(),
                product.getQuantity(),
                product.getInventoryStatus(),
                product.getRating()
        );
    }

    public static Product toEntity(ProductRequest productRequest){
        return new Product()
                .setCode(productRequest.getCode())
                .setName(productRequest.getName())
                .setDescription(productRequest.getDescription())
                .setImage(productRequest.getImage())
                .setPrice(productRequest.getPrice())
                .setCategory(productRequest.getCategory())
                .setQuantity(productRequest.getQuantity())
                .setInventoryStatus(productRequest.getInventoryStatus())
                .setRating(productRequest.getRating());
    }

}
