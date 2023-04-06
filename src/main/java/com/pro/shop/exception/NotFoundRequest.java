package com.pro.shop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotFoundRequest {

    private final String message;
    private final int httpStatusCode;

}
