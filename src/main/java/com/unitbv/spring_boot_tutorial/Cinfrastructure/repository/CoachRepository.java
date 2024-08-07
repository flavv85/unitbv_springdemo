package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, String> {
    // custom methods natural language or nativeQuery (sql language)
    List<Coach> findAllByNameContaining(String name);

//    @Modifying
    @Query(value = "DELETE FROM COACH WHERE COACH_ID = ?1", nativeQuery = true)
    void deleteCoachById(String coachId);
}
