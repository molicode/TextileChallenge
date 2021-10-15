package com.textile.challenge.pricecatalog.util.dtos.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.textile.challenge.pricecatalog.entity.Price;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDTO implements Serializable {

    private Integer brandId;
    private Integer productId;
    private PriceListDTO priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private String currency;

}