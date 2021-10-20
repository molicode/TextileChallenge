package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.PriceListNotFoundException;

/**
 * @author Luis Molina
 */
public interface PriceListService {

    void validatePriceListId(Integer priceListId) throws PriceListNotFoundException;

}
