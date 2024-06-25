package com.unitbv.spring_boot_tutorial.Ddomain.exceptions;

public class CoachNotPresent extends RuntimeException {
    public CoachNotPresent(String message) {
        super(message);
    }
}
