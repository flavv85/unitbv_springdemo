package com.unitbv.spring_boot_tutorial.Ddomain;

import java.util.List;

public interface Members {
    List<Member> getAllMembers();

    void createUpdateMember(Member member);
}
