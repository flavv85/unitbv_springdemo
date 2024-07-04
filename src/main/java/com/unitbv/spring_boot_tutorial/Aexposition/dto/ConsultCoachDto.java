package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
// without getter or following annotation the object can not be serialized
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ConsultCoachDto {

    public String id;
    public String name;
    public List<FitnessClassCoachDetailsDto> fitnessClasses;

}
