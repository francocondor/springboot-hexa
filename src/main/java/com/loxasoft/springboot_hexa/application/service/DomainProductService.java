package com.loxasoft.springboot_hexa.application.service;

import com.loxasoft.springboot_hexa.domain.model.Product;
import com.loxasoft.springboot_hexa.domain.puerto.ProductRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class DomainProductService implements ProductService {

    private final ProductRepository productRepository;

    public DomainProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return this.productRepository.getProducts();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return this.productRepository.getProduct(id);
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getId() == null) {
            product.setDateCreated(LocalDateTime.now());
        }
        product.setDateUpdated(LocalDateTime.now());
        return this.productRepository.saveProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteProductById(id);
    }
}