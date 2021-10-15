package com.textile.challenge.pricecatalog.util.responde;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceBinderResponse<T> {
    private String status;
    private String code;
    private String message;
    private T data;
}
