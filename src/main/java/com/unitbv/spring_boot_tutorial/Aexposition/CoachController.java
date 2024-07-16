package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateCoachDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mappers.CoachMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.coach.*;
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
    private final UpdateCoach updateCoach;
    private final DeleteCoach deleteCoach;

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
    @GetMapping(value = "/by-id")
    public ResponseEntity<ConsultCoachDto> consultById2(@RequestParam String coachId) {
        return new ResponseEntity<>(coachMapperService.mapFromDomain(consultCoachById.consult(coachId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateCoachDto dto) {
        Coach toBePersistedCoach = coachMapperService.mapToEntity(dto, null);
        createCoach.create(toBePersistedCoach);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultCoachDto> updateCoach(
            @PathVariable String id,
            @RequestBody CreateUpdateCoachDto dto) {
        Coach toBeUpdatedCoach = coachMapperService.mapToEntity(dto, id);
        ConsultCoachDto response = coachMapperService.mapFromDomain(updateCoach.update(toBeUpdatedCoach));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id/{id}")
    public ResponseEntity<Void> deleteCoachById(@PathVariable(value = "id") String id) {
        deleteCoach.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable(value = "id") String id) {
        deleteCoach.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
