package com.textile.challenge.pricecatalog.util.exceptions;

public class ProductNotFoundException extends Exception {
    /**
     *
     * @param errorMessage
     */
    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
