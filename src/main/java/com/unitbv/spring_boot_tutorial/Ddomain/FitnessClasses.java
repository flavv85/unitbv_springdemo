package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface FitnessClasses {
    Optional<FitnessClass> getById(String id);
    List<FitnessClass> getAllFitnessClasses();
    void createOrUpdate(FitnessClass fitnessClass);
}
