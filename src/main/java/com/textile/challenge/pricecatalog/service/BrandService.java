package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;

/**
 * @author Luis Molina
 */
public interface BrandService {

    /**
     *
     * Método de la interfaz BrandService que valida si el id de candea (brand) existe
     *
     * @param brandId
     * @throws BrandNotFoundException
     */
    void validateBrandId(Integer brandId) throws BrandNotFoundException;

}
