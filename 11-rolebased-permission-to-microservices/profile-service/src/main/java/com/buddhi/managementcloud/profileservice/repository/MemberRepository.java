package com.buddhi.managementcloud.profileservice.repository;


import com.buddhi.managementcloud.commons.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
