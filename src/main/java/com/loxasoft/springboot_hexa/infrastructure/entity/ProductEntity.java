package com.loxasoft.springboot_hexa.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 4 y 50 caracteres")
    @NotBlank(message = "El nombre es requerido")
    private String name;
    @NotBlank(message = "La descripción es requerida")
    private String description;
    private String urlImage;
    @NotBlank(message = "El precio es requerido")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double price;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;
}
