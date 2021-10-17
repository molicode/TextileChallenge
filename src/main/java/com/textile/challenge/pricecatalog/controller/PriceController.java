package com.textile.challenge.pricecatalog.controller;

import com.textile.challenge.pricecatalog.service.PriceService;
import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.PriceNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;
import com.textile.challenge.pricecatalog.util.responde.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/productId/{productId}/brandId/{brandId}/price")
    public PriceResponse<PriceDTO> getProductPrice(
            @PathVariable Integer productId,
            @PathVariable Integer brandId,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
    ) throws PriceNotFoundException, BrandNotFoundException, ProductNotFoundException {
        return new PriceResponse<>(
                SERVICE_SUCCESS, String.valueOf(HttpStatus.OK), SERVICE_OK,
                priceService.getProductPrice(productId, brandId, date));
    }

}
