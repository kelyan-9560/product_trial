package org.example.product_trial.product.domain.services;

import org.example.product_trial.product.domain.entities.Product;
import org.example.product_trial.product.domain.exceptions.ProductException;
import org.example.product_trial.product.domain.mappers.ProductMapper;
import org.example.product_trial.product.infrastructure.repositories.ProductRepository;
import org.example.product_trial.product.infrastructure.web.requests.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(ProductRequest productRequest){
        var product = ProductMapper.toEntity(productRequest);
        return productRepository.save(product);
    }

    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException("Product with id < " + productId + " > not found"));
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product update(Long productId, ProductRequest productRequest){
        var product = getById(productId);

        var productUpdated = product
                .setCode(productRequest.getCode() == null ? product.getCode() : productRequest.getCode())
                .setName(productRequest.getName() == null ? product.getName() : productRequest.getName())
                .setDescription(productRequest.getDescription() == null ? product.getDescription() : productRequest.getDescription())
                .setImage(productRequest.getImage() == null ? product.getImage() : productRequest.getImage())
                .setPrice(productRequest.getPrice() == null ? product.getPrice() : productRequest.getPrice())
                .setCategory(productRequest.getCategory() == null ? product.getCategory() : productRequest.getCategory())
                .setQuantity(productRequest.getQuantity() == null ? product.getQuantity() : productRequest.getQuantity())
                .setInventoryStatus(productRequest.getInventoryStatus() == null ? product.getInventoryStatus() : productRequest.getInventoryStatus())
                .setRating(productRequest.getRating() == null ? product.getRating() : productRequest.getRating());

        return productRepository.save(productUpdated);
    }

    public void delete(Long productId){
        var product = getById(productId);
        productRepository.delete(product);
    }


}
