package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CreateFitnessClassDto {

    String startTime;
    String endTime;
    String coachId;


}
