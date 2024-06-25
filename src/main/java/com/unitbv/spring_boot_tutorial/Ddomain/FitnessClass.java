package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FITNESS_CLASS")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FitnessClass {

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    Coach coach;

    @Id
    @Column(name = "fitness_class_id", nullable = false)
    String id;

    @Column(name = "start_time", nullable = false)
    LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    LocalDateTime endTime;

    @ManyToMany
    @JoinTable(
            name = "FITNESS_CLASSES_MEMBERS",
            joinColumns = @JoinColumn(name = "fitness_class_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    Set<Member> members = new HashSet<>();


    //TODO add a method to check if the duration is valid >1 && <3 hours
    public boolean isIntervalValid() {
        Long duration = duration();
        return duration >= 1L && duration <= 3L;
    }

    public Long duration() {
        return Duration.between(this.startTime, this.endTime).toHours();
    }

}
