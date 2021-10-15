package com.textile.challenge.pricecatalog.util.dtos.business;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer priceListId;
    private String description;
}
