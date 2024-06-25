package com.unitbv.spring_boot_tutorial.Ddomain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COACH")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Coach {

    @Id
    @Column(name = "coach_id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FitnessClass> fitnessClasses = new ArrayList<>();
//
//    public Coach(String id, String name, List<FitnessClass> fitnessClasses) {
//        this.id = id;
//        this.name = name;
//        this.fitnessClasses = fitnessClasses;
//    }
//
//    public Coach() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<FitnessClass> getFitnessClasses() {
//        return fitnessClasses;
//    }
//
//    public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
//        this.fitnessClasses = fitnessClasses;
//    }

    public void addFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.add(fitnessClass);
        fitnessClass.setCoach(this);
    }

    public void removeFitnessClass(FitnessClass fitnessClass) {
        fitnessClasses.remove(fitnessClass);
        fitnessClass.setCoach(null);
    }

}
