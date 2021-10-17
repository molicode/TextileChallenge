package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.PriceList;
import com.textile.challenge.pricecatalog.repository.PriceListRepository;
import com.textile.challenge.pricecatalog.util.exceptions.PriceListNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * @author Luis Molina
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class PriceListImplTest {

    @Mock
    PriceListRepository priceListRepository;

    @InjectMocks
    PriceListImpl priceListService;

    /**
     *
     */
    @Test
    public void validateIncorrectBrandId() {
        Optional<PriceList> priceListOptional = Optional.empty();
        when(priceListRepository.findById(66)).thenReturn(priceListOptional);
        assertThrows(PriceListNotFoundException.class, () -> {
            priceListService.validatePriceListId(66);
        });
    }

}