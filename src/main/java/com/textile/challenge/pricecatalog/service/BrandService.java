package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;

public interface BrandService {

    /**
     *
     * @param brandId
     * @throws BrandNotFoundException
     */
    void validateBrandId(Integer brandId) throws BrandNotFoundException;

}
