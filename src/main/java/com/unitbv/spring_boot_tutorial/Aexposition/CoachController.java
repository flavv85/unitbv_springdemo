package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
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

    private final ConsultAllCoaches consultAllCoaches;
    private final CoachMapperService coachMapperService;
    private final ConsultCoachById consultCoachById;
    private final CreateCoach createCoach;

    @GetMapping
    public List<ConsultCoachDto> consultAll() {
        List<Coach> coachList = consultAllCoaches.consult();
        List<ConsultCoachDto> consultCoachDtoList = coachList.stream().map(coach -> coachMapperService.mapFromDomain(coach)).toList();
        return consultCoachDtoList;
    }

    // return response entity
    @GetMapping("/re")
    public ResponseEntity<List<ConsultCoachDto>> consultAll2() {
        List<Coach> coachList = consultAllCoaches.consult();
        List<ConsultCoachDto> consultCoachDtoList = coachList.stream().map(coach -> coachMapperService.mapFromDomain(coach)).toList();
        return ResponseEntity.ok(consultCoachDtoList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ConsultCoachDto>> consultAllByName(@PathVariable String name) {
        List<Coach> coachList = consultAllCoaches.consultByName(name);
        List<ConsultCoachDto> consultCoachDtoList = coachList.stream().map(coach -> coachMapperService.mapFromDomain(coach)).toList();
        return ResponseEntity.ok(consultCoachDtoList);
    }

    // pass pathVariable
    @GetMapping("/{coachId}")
    public ResponseEntity<ConsultCoachDto> consultById(@PathVariable String coachId) {
        return new ResponseEntity<>(coachMapperService.mapFromDomain(consultCoachById.consult(coachId)), HttpStatus.OK);
    }

    // pass requestParam
    @GetMapping("/by-id")
    public ResponseEntity<ConsultCoachDto> consultById2(@RequestParam String coachId) {
        return new ResponseEntity<>(coachMapperService.mapFromDomain(consultCoachById.consult(coachId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCoachDto dto) {
        Coach toBePersistedCoach = coachMapperService.mapToEntity(dto);
        createCoach.create(toBePersistedCoach);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
