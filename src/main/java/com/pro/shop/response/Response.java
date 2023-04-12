package com.pro.shop.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private boolean success;
    private int httpStatusCode;

}
