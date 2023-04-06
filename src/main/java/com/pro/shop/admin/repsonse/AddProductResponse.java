package com.pro.shop.admin.repsonse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AddProductResponse {

    private boolean success;
    private Long id;

}
