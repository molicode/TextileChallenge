package com.textile.challenge.pricecatalog.util.exceptions;

import com.textile.challenge.pricecatalog.util.dtos.errors.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFoundExceptions extends PriceCatalogExceptions {

    public NotFoundExceptions(final String code, final String message) {
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundExceptions(final String code, final String message, ErrorDTO data) {
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
}
