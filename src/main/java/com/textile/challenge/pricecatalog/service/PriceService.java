package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.PriceNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;

import java.time.LocalDateTime;

/**
 * @author Luis Molina
 */
public interface PriceService {

    /**
     *
     * Método getProductPrice() del servicio PriceService
     * Nos devuelve el precio a aplicar a un prodcuto
     * de acuerdo a una tarifa en una fecha en particular.
     *
     * @param productId
     * @param brandId
     * @param applyDate
     * @return
     * @throws PriceNotFoundException
     * @throws BrandNotFoundException
     * @throws ProductNotFoundException
     */
    PriceDTO getProductPrice(Integer productId, Integer brandId, LocalDateTime applyDate) throws PriceNotFoundException, BrandNotFoundException, ProductNotFoundException;

}
