package com.textile.challenge.pricecatalog.util.exceptions;

/**
 * @author Luis Molina
 */
public class BrandNotFoundException extends Exception {
    /**
     * @param errorMessage
     */
    public BrandNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
