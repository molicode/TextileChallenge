package com.textile.challenge.pricecatalog.controller;

import com.textile.challenge.pricecatalog.service.PricesService;
import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.exceptions.PriceCatalogExceptions;
import com.textile.challenge.pricecatalog.util.responde.PriceBinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController()
@RequestMapping(path = "/product")
public class ProductController {

    private static final String SERVICE_SUCCESS = "Success";
    private static final String SERVICE_OK = "OK";

    private final PricesService pricesService;

    @Autowired
    public ProductController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping("/price/{productId}/brand{brandId}/{date}")
    public PriceBinderResponse<PriceDTO> getProductPrice(
            @PathVariable Long productId,
            @PathVariable Long brandId,
            @PathVariable(value="date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime aplicationDate) throws PriceCatalogExceptions {
        return new PriceBinderResponse<>(
                SERVICE_SUCCESS, String.valueOf(HttpStatus.OK), SERVICE_OK, pricesService.getProductPrice(productId, brandId, aplicationDate));
    }

}
