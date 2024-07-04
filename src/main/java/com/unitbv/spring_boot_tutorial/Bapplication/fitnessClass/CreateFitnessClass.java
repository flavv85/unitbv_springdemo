package com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.CoachNotPresent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateFitnessClass {

    FitnessClasses fitnessClasses;

    public void create(FitnessClass fitnessClass) {
        //TODO add a validate method if coach has no training class assigned
        //TODO ! create custom error if validation is false to understand better the error, eg: display coach's name
        if (!isValid(fitnessClass)) {
            throw new CoachNotPresent(String.format("Fitness class with id: %s has no coach assigned", fitnessClass.getId()));
        }
        //TODO use the class validation to check if duration is not valid
        //TODO !create custom error
        //TODO !! create a single private method to contain all validations
        fitnessClasses.createOrUpdate(fitnessClass);
    }

    private boolean isValid(FitnessClass fitnessClass) {
        return !ObjectUtils.isEmpty(fitnessClass.getCoach());
    }

}
