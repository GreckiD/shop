package com.pro.shop.product;

import com.pro.shop.category.Category;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private Integer quantity;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Category> categories;

}
