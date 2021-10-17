package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.PriceListNotFoundException;

public interface PriceListService {
    /**
     *
     * @param priceListId
     * @throws PriceListNotFoundException
     */
    void validatePriceListId(Integer priceListId) throws PriceListNotFoundException;

}
