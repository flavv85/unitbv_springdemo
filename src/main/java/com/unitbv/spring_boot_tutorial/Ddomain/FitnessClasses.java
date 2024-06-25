package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.Optional;

public interface FitnessClasses {
    Optional<FitnessClass> getById(String id);
}
