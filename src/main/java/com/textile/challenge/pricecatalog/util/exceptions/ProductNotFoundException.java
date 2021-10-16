package com.textile.challenge.pricecatalog.util.exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
