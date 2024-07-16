package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.implementation;

import com.unitbv.spring_boot_tutorial.Cinfrastructure.repository.MembersRepository;
import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import com.unitbv.spring_boot_tutorial.Ddomain.Members;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MembersSdj implements Members {

    MembersRepository membersRepository;
    private static final String SORT_ATTRIBUTE = "nickname";

    @Override
    public List<Member> getAllMembers(boolean isSorted) {
        //TODO add a sort by nickname asc if isSortedIsTrue
        return isSorted ? membersRepository.findAll(Sort.by(Sort.Direction.ASC, SORT_ATTRIBUTE)) : membersRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(String id) {
        if (StringUtils.hasText(id)) {
            return membersRepository.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public void createUpdateMember(Member member) {

    }
}
