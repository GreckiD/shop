package com.pro.shop.admin.repsonse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MessageResponse {

    private boolean success;
    private String message;
    private int httpStatusCode;
}
