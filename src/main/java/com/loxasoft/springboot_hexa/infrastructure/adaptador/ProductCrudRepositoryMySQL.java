package com.loxasoft.springboot_hexa.infrastructure.adaptador;

import com.loxasoft.springboot_hexa.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepositoryMySQL extends CrudRepository<ProductEntity, Integer> {
}
