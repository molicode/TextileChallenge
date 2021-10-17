package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.Product;
import com.textile.challenge.pricecatalog.repository.ProductRepository;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;
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
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void validateIncorrectBrandId() {
        Optional<Product> productOptional = Optional.empty();
        when(productRepository.findById(3545555)).thenReturn(productOptional);
        assertThrows(ProductNotFoundException.class, () -> {
            productService.validateProductId(3545555);
        });
    }
}