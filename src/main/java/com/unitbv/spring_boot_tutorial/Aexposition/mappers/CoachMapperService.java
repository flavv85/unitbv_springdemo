package com.unitbv.spring_boot_tutorial.Aexposition.mappers;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.CoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClassDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CoachMapperService {

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
        Coach coach = new Coach();
        coach.setId(String.valueOf(UUID.randomUUID()));
        coach.setName(dto.getName());
        return coach;
    }

}
