package com.unitbv.spring_boot_tutorial.Ddomain.exceptions;

public class FitnessClassNotPresent extends RuntimeException {
    public FitnessClassNotPresent(String message) {
        super(message);
    }
}
