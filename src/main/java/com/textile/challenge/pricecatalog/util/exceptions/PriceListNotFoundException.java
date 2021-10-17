package com.textile.challenge.pricecatalog.util.exceptions;

/**
 * @author Luis Molina
 */
public class PriceListNotFoundException extends Exception {
    /**
     * @param errorMessage
     */
    public PriceListNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}