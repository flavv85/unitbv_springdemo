package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.CoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mappers.CoachMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultAllCoaches;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.ConsultCoachById;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.CreateCoach;
import com.unitbv.spring_boot_tutorial.Ddomain.Coach;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/coach")
public class CoachController {

    ConsultAllCoaches consultAllCoaches;
    CoachMapperService coachMapperService;
    ConsultCoachById consultCoachById;
    CreateCoach createCoach;

    @GetMapping
    public List<CoachDto> consultAll() {
        List<Coach> coachList = consultAllCoaches.consult();
        List<CoachDto> coachDtoList = coachList.stream().map(coach -> coachMapperService.mapFromDomain(coach)).toList();
        return coachDtoList;
    }

    // return response entity
    @GetMapping("/re")
    public ResponseEntity<List<CoachDto>> consultAll2() {
        List<Coach> coachList = consultAllCoaches.consult();
        List<CoachDto> coachDtoList = coachList.stream().map(coach -> coachMapperService.mapFromDomain(coach)).toList();
        return ResponseEntity.ok(coachDtoList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CoachDto>> consultAllByName(@PathVariable String name) {
        List<Coach> coachList = consultAllCoaches.consultByName(name);
        List<CoachDto> coachDtoList = coachList.stream().map(coach -> coachMapperService.mapFromDomain(coach)).toList();
        return ResponseEntity.ok(coachDtoList);
    }

    // pass pathVariable
    @GetMapping("/{id}")
    public ResponseEntity<CoachDto> consultById(@PathVariable String coachId) {
        return new ResponseEntity<>(coachMapperService.mapFromDomain(consultCoachById.consult(coachId)), HttpStatus.OK);
    }

    // pass requestParam
    @GetMapping("/by-id")
    public ResponseEntity<CoachDto> consultById2(@RequestParam String coachId) {
        return new ResponseEntity<>(coachMapperService.mapFromDomain(consultCoachById.consult(coachId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCoachDto dto) {
        Coach toBePersistedCoach = coachMapperService.mapToEntity(dto);
        createCoach.create(toBePersistedCoach);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
