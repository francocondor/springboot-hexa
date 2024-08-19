package com.loxasoft.springboot_hexa.infrastructure.adaptador;

import com.loxasoft.springboot_hexa.domain.model.Product;
import com.loxasoft.springboot_hexa.domain.puerto.ProductRepository;
import com.loxasoft.springboot_hexa.infrastructure.entity.ProductEntity;
import com.loxasoft.springboot_hexa.infrastructure.exceptions.ResourceNotFoundException;
import com.loxasoft.springboot_hexa.infrastructure.rest.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class ProductRepositoryMySQL implements ProductRepository {

    private final ProductCrudRepositoryMySQL productCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductRepositoryMySQL(ProductCrudRepositoryMySQL productoCrudRepository) {
        this.productCrudRepository = productoCrudRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return this.productMapper.toProducts(this.productCrudRepository.findAll());
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        ProductEntity producto = this.productCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of(this.productMapper.toProduct(producto));
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = this.productMapper.toProductEntity(product);
        System.out.println("Code: "+ productEntity.getCode());
        return this.productMapper.toProduct(this.productCrudRepository.save(productEntity));
    }

    @Override
    public void deleteProductById(Integer id) {
        ProductEntity productEntity = this.productCrudRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        this.productCrudRepository.deleteById(productEntity.getId());
    }
}
