package com.textile.challenge.pricecatalog.util.dtos.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Luis Molina
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessErrorMessage {

    public static final String PRICE_NOT_FOUND_MESSAGE = "Precio no encontrado para el producto %s, en la fecha ingresada";
    public static final String BRAND_NOT_FOUND_MESSAGE = "Marca con el id %s no encontrada";
    public static final String PRODUCT_NOT_FOUND_MESSAGE = "Producto con el id %s no encontrado";
    public static final String PRICE_LIST_NOT_FOUND_MESSAGE = "Precio de lista con el id %s no encontrado";
    public static final String GENERAL_ERROR_MESSAGE = "No podemos procesar su consulta";

    private String description;

}
