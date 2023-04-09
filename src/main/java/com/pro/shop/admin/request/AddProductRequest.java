package com.pro.shop.admin.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

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

}
