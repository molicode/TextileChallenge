package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.repository.PriceRepository;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.PriceNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class PriceServiceImplTest {

    @Mock
    BrandService brandService;

    @Mock
    ProductService productService;

    @Mock
    PriceRepository priceRepository;

    @InjectMocks
    PriceServiceImpl priceService;

    @Test
    public void getProductPriceErrorTest() throws BrandNotFoundException, ProductNotFoundException {

        doNothing().when(brandService).validateBrandId(1);
        doNothing().when(productService).validateProductId(1);

        when(priceRepository.findByProductIdBrandIdAndApplyDate(1, 1, LocalDateTime.now())).thenReturn(null);

        assertThrows(PriceNotFoundException.class, () -> {
            priceService.getProductPrice(1, 1, LocalDateTime.now());
        });
    }

}