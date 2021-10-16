package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.PriceListNotFoundException;

public interface PriceListService {

    void validatePriceListId(Long priceListId) throws PriceListNotFoundException;

}
