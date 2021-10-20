package com.textile.challenge.pricecatalog.util.exceptions;

/**
 * @author Luis Molina
 */
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
