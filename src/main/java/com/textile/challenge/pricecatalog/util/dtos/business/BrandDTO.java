package com.textile.challenge.pricecatalog.util.dtos.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Luis Molina
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer brandId;
    private String name;

}
