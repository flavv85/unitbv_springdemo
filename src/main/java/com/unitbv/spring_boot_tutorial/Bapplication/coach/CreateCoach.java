package com.unitbv.spring_boot_tutorial.Bapplication.coach;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.FitnessClassNotPresent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateCoach {

    @Autowired
    Coaches coaches;

    public void create(Coach coach) {
        if (!isValid(coach)) {
            throw new FitnessClassNotPresent(String.format("Coach: %s has no fitness classes assigned", coach.getName()));
        }
        coaches.createOrUpdate(coach);
    }

    private boolean isValid(Coach coach) {
        return !ObjectUtils.isEmpty(coach.getFitnessClasses());
    }

}
