package com.loxasoft.springboot_hexa.application.service;

import com.loxasoft.springboot_hexa.domain.model.Product;

public interface ProductService {
    Iterable<Product> getProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}