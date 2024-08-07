package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

import java.util.List;

//@Getter
@Setter
@AllArgsConstructor
@Builder
// if using Lombok annotations No Args Constructor is mandatory or DTO can not be parsed, and we'll get an 400 failed to read request
@NoArgsConstructor
public class CreateUpdateCoachDto {
    public String name;

    public String getName() {
        return name;
    }


    public List<CreateUpdateFitnessClassDto> fitnessClasses;
    //TODO add a also a list of fitnessClass objects to demonstrate the power of the @OneToMany / @ManyToOne
//    public List<CreateUpdateFitnessClassDto> getFitnessClasses() {
//        return fitnessClasses;
//    }
}
