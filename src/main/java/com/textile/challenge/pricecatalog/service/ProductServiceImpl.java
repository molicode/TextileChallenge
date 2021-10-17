package com.textile.challenge.pricecatalog.service;

import com.textile.challenge.pricecatalog.entity.Product;
import com.textile.challenge.pricecatalog.repository.ProductRepository;
import com.textile.challenge.pricecatalog.util.dtos.errors.BusinessErrorMessage;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Luis Molina
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * @param productRepository
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Implementación del método de la interfaz ProductService que valida si un producto (productId) existe
     * @param productId
     * @throws ProductNotFoundException
     */
    @Override
    public void validateProductId(Integer productId) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException(String.format(BusinessErrorMessage.PRODUCT_NOT_FOUND_MESSAGE, productId));
        }

    }
}
