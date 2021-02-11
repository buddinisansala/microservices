package com.buddhi.managementcloud.profileservice.service;

import com.buddhi.managementcloud.commons.model.Member;
import com.buddhi.managementcloud.profileservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member fetchById(int profileId) {
        Optional<Member> member = memberRepository.findById(profileId);
        if (member.isPresent()) {
            return member.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Member> fetchAllProfiles() {
        return memberRepository.findAll();
    }
}