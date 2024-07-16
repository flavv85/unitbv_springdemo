package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import com.unitbv.spring_boot_tutorial.Ddomain.exceptions.UnknownObjectException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ConsultMemberById {

    Members members;

    public Member consult(String id) {
        return members.getMemberById(id).orElseThrow(() -> new UnknownObjectException(String.format("The member with id %s was not found", id)));
    }

}
