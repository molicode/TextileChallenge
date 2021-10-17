package com.textile.challenge.pricecatalog.util.responde;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PriceResponse<T> {
    private String status;
    private String code;
    private String message;
    private T data;
}
