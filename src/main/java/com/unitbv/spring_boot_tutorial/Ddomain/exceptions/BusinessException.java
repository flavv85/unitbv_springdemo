package com.unitbv.spring_boot_tutorial.Ddomain.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
