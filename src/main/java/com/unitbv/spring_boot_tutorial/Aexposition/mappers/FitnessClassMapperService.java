package com.unitbv.spring_boot_tutorial.Aexposition.mappers;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultCoachById;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class FitnessClassMapperService {

    ConsultCoachById consultCoachById;

    public ConsultFitnessClassDto mapFromDomain(FitnessClass fitnessClass) {
       return ConsultFitnessClassDto.builder()
               .id(fitnessClass.getId())
               .coachName(fitnessClass.getCoach().getName())
               //TODO extract formatter into private method
               .startTime(fitnessClass.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
               .endTime(fitnessClass.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
               //TODO extract into private method and add hours at the end if 2h+ or hour if 1h
               //TODO !if classes are less than 60 minutes display 1h. Round to 1+ if minutes above or equal 30
               .duration(String.valueOf(Duration.between(fitnessClass.getStartTime(), fitnessClass.getEndTime()).toHours()))
               .build();
    }

    public FitnessClass mapToEntity(CreateFitnessClassDto dto) {
       return FitnessClass.builder()
               .id(UUID.randomUUID().toString())
               .coach(consultCoachById.consult(dto.getCoachId()))
               //TODO make a constant for the formatter pattern
               .startTime(ObjectUtils.isEmpty(dto.getStartTime()) ? null : LocalDateTime.parse(dto.getStartTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
               .endTime(ObjectUtils.isEmpty(dto.getEndTime()) ? null : LocalDateTime.parse(dto.getEndTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")))
               .build();
    }

}
