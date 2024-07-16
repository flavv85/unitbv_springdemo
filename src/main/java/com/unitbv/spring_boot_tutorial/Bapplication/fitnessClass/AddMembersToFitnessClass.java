package com.unitbv.spring_boot_tutorial.Bapplication.fitnessClass;

import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClass;
import com.unitbv.spring_boot_tutorial.Ddomain.FitnessClasses;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddMembersToFitnessClass {


    //TODO import service already created find fitness class by id;
    ConsultFitnessClassById consultFitnessClassById;
    //TODO should create a service class in B-application layer
    Members members;
    FitnessClasses fitnessClasses;


    public void addMembers(String fitnessClassId, List<String> memberIds) {
        FitnessClass fitnessClass = consultFitnessClassById.consult(fitnessClassId);
        Set<Member> memberSet = new HashSet<>();
        List<String> notExistingIds = new ArrayList<>();
        //TODO add a validation if all members exist by id if not don't stop execution, just log the error
        memberIds.forEach(memberId -> members.getMemberById(memberId).ifPresentOrElse(memberSet::add, () -> notExistingIds.add(memberId)));

        fitnessClass.setMembers(memberSet);
        fitnessClasses.createOrUpdate(fitnessClass);

        log.info("Members with ids: {} added successfully. Members with ids: {} were not found and not added to fitness class with id {}",
                String.join(", ", memberSet.stream().map(Member::getId).toList()), String.join(", ", notExistingIds), fitnessClassId);
    }

}
