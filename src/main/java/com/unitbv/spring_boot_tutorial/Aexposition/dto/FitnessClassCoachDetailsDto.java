package com.unitbv.spring_boot_tutorial.Aexposition.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
// without getter or @JsonAutoDetect the object can not be serialized
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FitnessClassCoachDetailsDto {

    String id;
    String duration;

    public String appendHourToDuration(String duration) {
        if (duration.equals("1")) {
            return duration + " hour";
        }
        return duration + " hours";
    }

}
