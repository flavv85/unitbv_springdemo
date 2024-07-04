package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import java.util.List;

import java.util.List;

//@Getter
//@Setter
//@AllArgsConstructor
//@Builder
// if using Lombok annotations No Args Constructor is mandatory or DTO can not be parsed, and we'll get an 400 failed to read request
//@NoArgsConstructor
public class CreateUpdateCoachDto {
    public String name;

//    public CreateCoachDto() {
//    }


    public String getName() {
        return name;
    }

    //TODO add a also a list of fitnessClass objects to demonstrate the power of the @OneToMany / @ManyToOne

    public List<CreateUpdateFitnessClassDto> fitnessClasses;

    public List<CreateUpdateFitnessClassDto> getFitnessClasses() {
        return fitnessClasses;
    }
}
