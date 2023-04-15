package com.pro.shop.admin.repsonse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class IdentifierResponse {

    private boolean success;
    private Long id;
    private int httpStatusCode;

}
