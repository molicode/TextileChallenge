package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;

public interface BrandService {

    void validateBrandId(Long brandId) throws BrandNotFoundException;

}
