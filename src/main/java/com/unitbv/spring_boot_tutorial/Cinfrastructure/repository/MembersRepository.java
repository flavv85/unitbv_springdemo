package com.unitbv.spring_boot_tutorial.Cinfrastructure.repository;

import com.unitbv.spring_boot_tutorial.Ddomain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MembersRepository extends JpaRepository<Member, String> {
}
