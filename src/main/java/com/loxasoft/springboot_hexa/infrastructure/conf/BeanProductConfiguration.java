package com.loxasoft.springboot_hexa.infrastructure.conf;

import com.loxasoft.springboot_hexa.application.service.DomainProductService;
import com.loxasoft.springboot_hexa.application.service.ProductService;
import com.loxasoft.springboot_hexa.domain.puerto.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProductConfiguration {

    @Bean
    ProductService productBeanService(final ProductRepository productRepository){
        return new DomainProductService(productRepository);
    }
}
