package com.textile.challenge.pricecatalog.util.exceptions;

import com.textile.challenge.pricecatalog.util.dtos.errors.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerExceptions extends PriceCatalogExceptions {

    public InternalServerExceptions(final String code, final String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerExceptions(final String code, final String message, ErrorDTO data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
