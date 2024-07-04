package com.unitbv.spring_boot_tutorial.Aexposition;

import com.unitbv.spring_boot_tutorial.Aexposition.dto.ConsultFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.dto.CreateUpdateFitnessClassDto;
import com.unitbv.spring_boot_tutorial.Aexposition.mappers.FitnessClassMapperService;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.ConsultAllFitnessClasses;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.CreateFitnessClass;
import com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass.UpdateFitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fitness-class")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FitnessClassController {

    ConsultAllFitnessClasses consultAllFitnessClasses;
    FitnessClassMapperService fitnessClassMapperService;
    CreateFitnessClass createFitnessClass;
    UpdateFitnessClass updateFitnessClass;

    @GetMapping
    public ResponseEntity<List<ConsultFitnessClassDto>> consultAll() {
        List<FitnessClass> coachList = consultAllFitnessClasses.consult();
        List<ConsultFitnessClassDto> fitnessClassDtoList = coachList.stream().map(fitnessClassMapperService::mapFromDomain).toList();
        return ResponseEntity.ok(fitnessClassDtoList);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass toBePersistedFitnessClass = fitnessClassMapperService.mapToEntity(dto);
        createFitnessClass.create(toBePersistedFitnessClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{fitness_class_id}")
    public ResponseEntity<ConsultFitnessClassDto> update(
            @PathVariable String fitness_class_id, @RequestBody CreateUpdateFitnessClassDto dto) {
        FitnessClass fitnessClassUpdated = fitnessClassMapperService.mapToEntity(dto);
        //TODO return the dto of the updated entity
        return new ResponseEntity<>(fitnessClassMapperService.mapFromDomain(updateFitnessClass.update(fitnessClassUpdated, fitness_class_id)), HttpStatus.OK);
    }

}
