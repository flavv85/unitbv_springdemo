package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.FitnessClassRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FitnessClassesSdj implements FitnessClasses {
    @Autowired
    private final FitnessClassRepository fitnessClassRepository;

    public FitnessClassesSdj(FitnessClassRepository fitnessClassRepository) {
        this.fitnessClassRepository = fitnessClassRepository;
    }

    @Override
    public Optional<FitnessClass> getById(String id) {
      return fitnessClassRepository.findById(id);
    }
}
