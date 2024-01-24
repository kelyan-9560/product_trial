package org.example.product_trial.product.domain.mappers;

import org.example.product_trial.product.domain.entities.Product;
import org.example.product_trial.product.infrastructure.web.requests.ProductRequest;
import org.example.product_trial.product.infrastructure.web.responses.ProductResponse;

public class ProductMapper {

    public static ProductResponse toResponse(Product product){
        return new ProductResponse()
                .setId(product.getId())
                .setCode(product.getCode())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setImage(product.getImage())
                .setPrice(product.getPrice())
                .setCategory(product.getCategory())
                .setQuantity(product.getQuantity())
                .setInventoryStatus(product.getInventoryStatus())
                .setRating(product.getRating());

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
