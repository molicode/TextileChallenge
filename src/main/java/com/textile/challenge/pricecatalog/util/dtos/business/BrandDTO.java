package com.textile.challenge.pricecatalog.util.dtos.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDTO {

    private Long brandId;
    private String name;

}
