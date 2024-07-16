package com.unitbv.spring_boot_tutorial.Bapplication.member;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class ConsultAllMembersIds {

    Members members;

    public List<String> consult() {
        return members.getAllMembers(false).stream().map(Member::getId).toList();
    }

}
