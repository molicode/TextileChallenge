package com.textile.challenge.pricecatalog.util.exceptions;

public class PriceNotFoundException extends Exception {
    /**
     *
     * @param errorMessage
     */
    public PriceNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
