package com.textile.challenge.pricecatalog.util.dtos.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessError {

    public static final String PRICE_NOT_FOUND_MESSAGE = "Precio no encontrado para el producto %s, en la fecha ingresada";
    public static final String GENERAL_ERROR_MESSAGE = "No podemos procesar su consulta";
    
    private String description;

}
