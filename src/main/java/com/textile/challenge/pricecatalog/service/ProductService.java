package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;

/**
 * @author Luis Molina
 */
public interface ProductService {
    /**
     * Método de la interfaz ProductService que valida si un producto (productId) existe
     *
     * @param productId
     * @throws ProductNotFoundException
     */
    void validateProductId(Integer productId) throws ProductNotFoundException;

}
