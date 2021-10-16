package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;

public interface ProductService {

    void validateProductId(Long productId) throws ProductNotFoundException;

}
