package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@Builder
// if using Lombok annotations No Args Constructor is mandatory or DTO can not be parsed, and we'll get an 400 failed to read request
//@NoArgsConstructor
public class CreateCoachDto {
    public String name;

//    public CreateCoachDto() {
//    }


    public String getName() {
        return name;
    }
}
