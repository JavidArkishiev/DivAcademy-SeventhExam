package com.example.newtasks.service;

import com.example.newtasks.model.Product;
import com.example.newtasks.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProducts(Integer id, Product product) {
       Product productEntity= productRepository.findById(id).orElse(null);
       if (product!=null){
           productEntity.setName(product.getName());
           productEntity.setPrice(product.getPrice());
           productRepository.save(productEntity);
           return productEntity;
       }
       return null;
    }
}
