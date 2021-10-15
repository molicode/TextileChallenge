package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.exceptions.PriceCatalogExceptions;

import java.time.LocalDateTime;

public interface PricesService {

    PriceDTO getProductPrice(Long productId, Long brandId, LocalDateTime applyDate) throws PriceCatalogExceptions;

}
