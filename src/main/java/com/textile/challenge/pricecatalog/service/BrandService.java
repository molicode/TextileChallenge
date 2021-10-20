package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;

/**
 * @author Luis Molina
 */
public interface BrandService {

    void validateBrandId(Integer brandId) throws BrandNotFoundException;

}
