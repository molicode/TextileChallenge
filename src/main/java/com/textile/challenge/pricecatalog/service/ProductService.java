package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;

public interface ProductService {

    void validateProductId(Integer productId) throws ProductNotFoundException;

}
