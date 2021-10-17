package com.textile.challenge.pricecatalog.controller;

import com.textile.challenge.pricecatalog.util.dtos.business.PriceDTO;
import com.textile.challenge.pricecatalog.util.responde.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Luis Molina
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerChallengeTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    ModelMapper model = new ModelMapper();

    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA).
     * Se espera un precio final 35.5 con la tarifa con ID 1.
     */
    @Test
    public void getPriceIntegrationTestOne() {
        Double expectedPrice = 35.5;
        Integer priceListId = 1;

        String url = this.createURLWithParams(35455, 1, "2021-06-14T10:00:00.000-00:00");
        PriceResponse priceResponse = this.restTemplate.getForObject(url, PriceResponse.class);
        PriceDTO priceDTO = model.map(priceResponse.getData(), PriceDTO.class);

        assertEquals(priceDTO.getPrice(), expectedPrice);
        assertEquals(priceDTO.getPriceList(), priceListId);
    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA).
     * Se espera un precio final 25.45 con la tarifa con ID 2.
     */
    @Test
    public void getPriceIntegrationTestTwo() {
        Double expectedPrice = 25.45;
        Integer priceListId = 2;

        String url = this.createURLWithParams(35455, 1, "2021-06-14T16:00:00.000-00:00");
        PriceResponse priceResponse = this.restTemplate.getForObject(url, PriceResponse.class);
        PriceDTO priceDTO = model.map(priceResponse.getData(), PriceDTO.class);

        assertEquals(priceDTO.getPrice(), expectedPrice);
        assertEquals(priceDTO.getPriceList(), priceListId);
    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA).
     * Se espera un precio final 35.50 con la tarifa con ID 1.
     */
    @Test
    public void getPriceIntegrationTestThree() {
        Double expectedPrice = 35.50;
        Integer priceListId = 1;

        String url = this.createURLWithParams(35455, 1, "2021-06-14T21:00:00.000-00:00");
        PriceResponse priceResponse = this.restTemplate.getForObject(url, PriceResponse.class);
        PriceDTO priceDTO = model.map(priceResponse.getData(), PriceDTO.class);

        assertEquals(priceDTO.getPrice(), expectedPrice);
        assertEquals(priceDTO.getPriceList(), priceListId);
    }

    /**
     * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA).
     * Se espera un precio final 30.50 con la tarifa con ID 3.
     */
    @Test
    public void getPriceIntegrationTestFour() {
        Double expectedPrice = 30.50;
        Integer priceListId = 3;

        String url = this.createURLWithParams(35455, 1, "2021-06-15T10:00:00.000-00:00");
        PriceResponse priceResponse = this.restTemplate.getForObject(url, PriceResponse.class);
        PriceDTO priceDTO = model.map(priceResponse.getData(), PriceDTO.class);

        assertEquals(priceDTO.getPrice(), expectedPrice);
        assertEquals(priceDTO.getPriceList(), priceListId);
    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA).
     * Se espera un precio final 38.95 con la tarifa con ID 4.
     */
    @Test
    public void getPriceIntegrationTestFive() {
        Double expectedPrice = 38.95;
        Integer priceListId = 4;

        String url = this.createURLWithParams(35455, 1, "2021-06-16T21:00:00.000-00:00");
        PriceResponse priceResponse = this.restTemplate.getForObject(url, PriceResponse.class);
        PriceDTO priceDTO = model.map(priceResponse.getData(), PriceDTO.class);

        assertEquals(priceDTO.getPrice(), expectedPrice);
        assertEquals(priceDTO.getPriceList(), priceListId);
    }

    private String createURLWithParams(Integer productId, Integer brandId, String date) {
        StringBuilder builder = new StringBuilder("http://localhost:").append(port)
                .append("/product/productId/").append(productId)
                .append("/brandId/").append(brandId)
                .append("/price?date=").append(date);
        return builder.toString();
    }


}


