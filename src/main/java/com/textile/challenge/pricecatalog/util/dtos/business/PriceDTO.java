package com.textile.challenge.pricecatalog.util.dtos.business;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Luis Molina
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

}