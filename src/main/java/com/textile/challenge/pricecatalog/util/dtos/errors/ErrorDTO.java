package com.textile.challenge.pricecatalog.util.dtos.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime timestamp;
    private int status;
    private String error;

}

