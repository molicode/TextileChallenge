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
    /**
     *
     * @param exception
     * @param request
     * @return
     * @throws IOException
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandlePriceNotFound(Exception exception, WebRequest request) throws IOException {
        return this.formateErrorResponse(exception, request);
    }

    /**
     *
     * @param exception
     * @param request
     * @return
     * @throws IOException
     */
    @ExceptionHandler(PriceListNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandlePriceListNotFound(Exception exception, WebRequest request) throws IOException {
        return this.formateErrorResponse(exception, request);
    }

    /**
     *
     * @param exception
     * @param request
     * @return
     * @throws IOException
     */
    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandleBrandNotFound(Exception exception, WebRequest request) throws IOException {
        return this.formateErrorResponse(exception, request);
    }

    /**
     *
     * @param exception
     * @param request
     * @return
     * @throws IOException
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> springHandleProductNotFound(Exception exception, WebRequest request) throws IOException {
        return this.formateErrorResponse(exception, request);
    }

    /**
     *
     * @param exception
     * @param request
     * @return
     * @throws IOException
     */
    private ResponseEntity<ErrorDTO> formateErrorResponse(Exception exception, WebRequest request) throws IOException {
        ErrorDTO errorDto = ErrorDTO.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(exception.getMessage()).build();

        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
