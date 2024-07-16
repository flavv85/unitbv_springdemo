package com.unitbv.spring_boot_tutorial.Aexposition.mappers;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.FitnessClassCoachDetailsDto;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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

    //TODO for update coach entity:
    // 1. create a new method or
    // 2. send a isUpdated boolean and pass also the id of the updated entity or
    // 3. add the id param in dto and check if exists set it or else generate a new one
    public Coach mapToEntity(CreateUpdateCoachDto dto, String coachId) {
        Coach coach = new Coach();
        coach.setId(StringUtils.hasText(coachId) ? coachId : String.valueOf(UUID.randomUUID()));
        coach.setName(dto.getName());
//
//        List<FitnessClass> fitnessClasses = new ArrayList<>();
//
//        if (!CollectionUtils.isEmpty(dto.getFitnessClasses())) {
//            dto.getFitnessClasses().forEach(fitnessClass -> {
//                FitnessClass newFitnessClass = FitnessClass
//                        .builder()
//                        .id(UUID.randomUUID().toString())
//                        .coach(coach)
//                        .startTime(ObjectUtils.isEmpty(fitnessClass.getStartTime()) ? null : LocalDateTime.parse(fitnessClass.getStartTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
//                        .endTime(ObjectUtils.isEmpty(fitnessClass.getEndTime()) ? null : LocalDateTime.parse(fitnessClass.getEndTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
//                        .build();
//                fitnessClasses.add(newFitnessClass);
//            });
//        }
//        coach.setFitnessClasses(fitnessClasses);
        return coach;
    }

}
