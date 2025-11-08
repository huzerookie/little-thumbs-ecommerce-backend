package com.littlethumbs.service;

import com.littlethumbs.model.Product;
import com.littlethumbs.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) {
    	this.repo = repo;
    }
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(String id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product updateProduct(String id, Product product) {
        product.setId(id);
        return repo.save(product);
    }

    public void deleteProduct(String id) {
        repo.deleteById(id);
    }
}
