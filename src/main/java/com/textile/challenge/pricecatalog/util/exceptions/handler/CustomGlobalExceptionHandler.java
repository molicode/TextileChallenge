package com.textile.challenge.pricecatalog.util.exceptions.handler;

import com.textile.challenge.pricecatalog.util.dtos.errors.ErrorDTO;
import com.textile.challenge.pricecatalog.util.exceptions.BrandNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.PriceListNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.PriceNotFoundException;
import com.textile.challenge.pricecatalog.util.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandlePriceNotFound(Exception ex, WebRequest request) throws IOException {
        return this.formateErrorResponse(ex, request);
    }

    @ExceptionHandler(PriceListNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandlePriceListNotFound(Exception ex, WebRequest request) throws IOException {
        return this.formateErrorResponse(ex, request);
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandleBrandNotFound(Exception ex, WebRequest request) throws IOException {
        return this.formateErrorResponse(ex, request);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandleProductNotFound(Exception ex, WebRequest request) throws IOException {
        return this.formateErrorResponse(ex, request);
    }

    private ResponseEntity<ErrorDTO> formateErrorResponse(Exception ex, WebRequest request) throws IOException {
        ErrorDTO errorDto = ErrorDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(ex.getMessage()).build();

        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
