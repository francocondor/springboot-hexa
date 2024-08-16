package com.loxasoft.springboot_hexa.application.service;

import com.loxasoft.springboot_hexa.domain.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> getProducts();

    Optional<Product> getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
