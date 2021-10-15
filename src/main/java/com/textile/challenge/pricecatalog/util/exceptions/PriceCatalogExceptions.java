package com.textile.challenge.pricecatalog.util.exceptions;

import com.textile.challenge.pricecatalog.util.dtos.errors.ErrorDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PriceCatalogExceptions extends Exception {

    private final String code;
    private final int responseCode;
    private final List<ErrorDTO> errorList = new ArrayList<>();

    public PriceCatalogExceptions(final String code, final int responseCode, String message) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public PriceCatalogExceptions(
            final String code, final int responseCode, final String message, List<ErrorDTO> errorList) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorList.addAll(errorList);
    }
}