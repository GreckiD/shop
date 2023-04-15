package com.pro.shop.admin.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddCategoryRequest {

    @NotBlank
    @NotEmpty
    private String name;

}
