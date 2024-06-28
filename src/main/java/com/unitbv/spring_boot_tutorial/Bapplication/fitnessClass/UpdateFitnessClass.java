package com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateFitnessClass {

    FitnessClasses fitnessClasses;

    public FitnessClass update(FitnessClass fitnessClass, String fitness_class_id) {

        fitnessClass.setId(fitness_class_id);

        //TODO !add a validate method if coach id is missing or not existing
        //TODO !add a validate method to check if startTime < endTime and duration length is valid (see class method)
        //TODO !!!create a validation to check and none the parameters of the fitness class has changed and inform the user!
        //TODO !create custom errors
        //TODO !!create a single private method to contain all validations
        fitnessClasses.createOrUpdate(fitnessClass);
        return fitnessClass;
    }

}
