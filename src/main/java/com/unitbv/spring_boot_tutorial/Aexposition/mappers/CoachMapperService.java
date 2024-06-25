package com.unitbv.spring_boot_tutorial.Aexposition.mappers;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.CoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClassDto;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.CreateCoach;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.ConsultFitnessClassById;
import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation.FitnessClassesSdj;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coaches;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CoachMapperService {

//    ConsultFitnessClassById consultFitnessClassById;
//    FitnessClassesSdj fitnessClassesSdj;

    public CoachDto mapFromDomain(Coach coach) {
        CoachDto coachDto = CoachDto.builder()
                .id(coach.getId())
                .name(coach.getName())
                .fitnessClasses(coach.getFitnessClasses().stream().map(this::mapFitnessClassFromDomain).toList())
                .build();
        return coachDto;
    }

    private FitnessClassDto mapFitnessClassFromDomain(FitnessClass fitnessClass) {
        FitnessClassDto fitnessClassDto = new FitnessClassDto();
        fitnessClassDto.setId(fitnessClass.getId());
        fitnessClassDto.setDuration(fitnessClassDto.appendHourToDuration(String.valueOf(fitnessClass.duration())));
        return fitnessClassDto;
    }

    public Coach mapToEntity(CreateCoachDto dto) {
        List<FitnessClass> fitnessClassList = new ArrayList<>();
        Coach coach = new Coach();
        coach.setName(dto.getName());
        coach.setId(String.valueOf(UUID.randomUUID()));
/*
        if (!dto.fitnessClassIds.isEmpty()) {
//            dto.fitnessClassIds.forEach(id -> {
//                FitnessClass fitnessClass = consultFitnessClassById.consult(id);
//                coach.addFitnessClass(fitnessClass);
//            });

            // implement logic to avoid breaking the app if any of the fitness classes id is incorrect
            dto.fitnessClassIds.forEach(id -> {
                fitnessClassesSdj.getById(id).ifPresent(fitnessClassList::add);
            });
        }
        coach.setFitnessClasses(fitnessClassList);

 */
        return coach;
    }

}
