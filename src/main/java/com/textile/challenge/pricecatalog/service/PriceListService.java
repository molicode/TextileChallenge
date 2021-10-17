package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.exceptions.PriceListNotFoundException;

/**
 * @author Luis Molina
 */
public interface PriceListService {
    /**
     *  Método de la interfaz PriceListService que valida si una tafifa (priceList) existe
     *
     * @param priceListId
     * @throws PriceListNotFoundException
     */
    void validatePriceListId(Integer priceListId) throws PriceListNotFoundException;

}
