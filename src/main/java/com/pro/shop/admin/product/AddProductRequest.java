package com.pro.shop.admin.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AddProductRequest {

    @NotBlank
    @NotEmpty
    private String name;
    private String description;
    private Integer quantity;
    private List<Long> categories;

}
