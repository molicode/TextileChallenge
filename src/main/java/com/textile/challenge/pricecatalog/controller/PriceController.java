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

/**
 * @author Luis Molina
 */
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

    /**
     *
     * Método controlador del servicio getProductPrice()
     * Nos devuelve el precio a aplicar a un prodcuto
     * de acuerdo a una tarifa en una fecha en particular.
     *
     * @param productId
     * @param brandId
     * @param date
     * @return
     * @throws PriceNotFoundException
     * @throws BrandNotFoundException
     * @throws ProductNotFoundException
     */
    @GetMapping("/productId/{productId}/brandId/{brandId}/price")
    public PriceResponse<PriceDTO> getProductPrice(
            @PathVariable Integer productId,
            @PathVariable Integer brandId,
            @RequestParam("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
    ) throws PriceNotFoundException, BrandNotFoundException, ProductNotFoundException {
        return new PriceResponse<>(
                SERVICE_SUCCESS,
                String.valueOf(HttpStatus.OK),
                SERVICE_OK,
                priceService.getProductPrice(productId, brandId, date));
    }

}
