package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ConsultFitnessClassDto {

    String id;
    String startTime;
    String endTime;
    String duration;
    String coachName;
    //TODO add the list of members attending fitness class and display only their nickname
}
