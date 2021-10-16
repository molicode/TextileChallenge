package com.textile.challenge.pricecatalog.controller;

import com.textile.challenge.pricecatalog.service.PriceService;
import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.PriceNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;
import com.textile.challenge.pricecatalog.util.responde.PriceBinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController()
@RequestMapping(path = "/product")
public class PriceController {

    private static final String SERVICE_SUCCESS = "Success";
    private static final String SERVICE_OK = "OK";

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/price/productId/{productId}/brandId/{brandId}/{date}")
    public PriceBinderResponse<PriceDTO> getProductPrice(
            @PathVariable Long productId,
            @PathVariable Long brandId,
            @PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
    ) throws PriceNotFoundException, BrandNotFoundException, ProductNotFoundException {
        return new PriceBinderResponse<>(
                SERVICE_SUCCESS, String.valueOf(HttpStatus.OK), SERVICE_OK,
                priceService.getProductPrice(productId, brandId, date));
    }

}