package com.textile.challenge.pricecatalog.util.exceptions;

/**
 * @author Luis Molina
 */
public class PriceNotFoundException extends Exception {
    /**
     * @param errorMessage
     */
    public PriceNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
