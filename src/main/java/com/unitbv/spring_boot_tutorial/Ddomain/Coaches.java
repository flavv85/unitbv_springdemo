package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;
import java.util.Optional;

public interface Coaches {

    Optional<Coach> getCoachById(String coachId);
    List<Coach> getAllCoaches();

    List<Coach> getAllCoachesByName(String name);

    void createOrUpdate(Coach coach);

}
