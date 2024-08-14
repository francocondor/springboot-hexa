package com.loxasoft.springboot_hexa.domain.puerto;

import com.loxasoft.springboot_hexa.domain.model.Product;

import java.util.Optional;

public interface ProductRepository {
    Iterable<Product> getProducts();
    Optional<Product> getProduct(Integer id);
    Product saveProduct(Product product);
    void deleteProduct(Integer id);
}
