package com.buddhi.managementcloud.profileservice.service;

import com.buddhi.managementcloud.commons.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {

    Member save(Member member);

    Member fetchById(int profileId);

    List<Member> fetchAllProfiles();
}
