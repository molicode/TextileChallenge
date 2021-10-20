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

    PriceDTO getProductPrice(Integer productId, Integer brandId, LocalDateTime applyDate) throws PriceNotFoundException, BrandNotFoundException, ProductNotFoundException;

}
