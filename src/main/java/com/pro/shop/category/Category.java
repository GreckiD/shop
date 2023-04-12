package com.pro.shop.category;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;

}
