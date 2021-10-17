package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.Brand;
import com.textile.challenge.pricecatalog.repository.BrandRepository;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class BrandServiceImplTest {

    @Mock
    BrandRepository brandRepository;

    @InjectMocks
    BrandServiceImpl brandService;

    @Test
    public void validateIncorrectBrandId() {
        Optional<Brand> brandOptional = Optional.empty();
        when(brandRepository.findById(66)).thenReturn(brandOptional);
        assertThrows(BrandNotFoundException.class, () -> {
            brandService.validateBrandId(66);
        });
    }
}