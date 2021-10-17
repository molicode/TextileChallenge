package com.textile.challenge.pricecatalog.util.dtos.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer priceListId;
    private String name;

}
