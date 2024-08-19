package com.loxasoft.springboot_hexa.infrastructure.exceptions;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;

}
