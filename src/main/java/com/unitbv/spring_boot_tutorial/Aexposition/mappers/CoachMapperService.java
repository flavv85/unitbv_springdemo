package com.unitbv.spring_boot_tutorial.Aexposition.mappers;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClassCoachDetailsDto;
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

    public ConsultCoachDto mapFromDomain(Coach coach) {
        ConsultCoachDto consultCoachDto = ConsultCoachDto.builder()
                .id(coach.getId())
                .name(coach.getName())
                .fitnessClasses(coach.getFitnessClasses().stream().map(this::mapFitnessClassFromDomain).toList())
                .build();
        return consultCoachDto;
    }

    private FitnessClassCoachDetailsDto mapFitnessClassFromDomain(FitnessClass fitnessClass) {
        FitnessClassCoachDetailsDto fitnessClassCoachDetailsDto = new FitnessClassCoachDetailsDto();
        fitnessClassCoachDetailsDto.setId(fitnessClass.getId());
        fitnessClassCoachDetailsDto.setDuration(fitnessClassCoachDetailsDto.appendHourToDuration(String.valueOf(fitnessClass.duration())));
        return fitnessClassCoachDetailsDto;
    }

    public Coach mapToEntity(CreateCoachDto dto) {
        Coach coach = new Coach();
        coach.setId(String.valueOf(UUID.randomUUID()));
        coach.setName(dto.getName());
        return coach;
    }

}
