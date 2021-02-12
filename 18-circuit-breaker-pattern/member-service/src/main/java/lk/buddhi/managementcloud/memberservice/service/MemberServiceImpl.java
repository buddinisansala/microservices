package lk.buddhi.managementcloud.memberservice.service;

import lk.buddhi.managementcloud.memberservice.repository.MemberRepository;
import lk.buddhi.managementcloud.model.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member findById(int id) {
        Optional<Member> member = memberRepository.findById(id);

        if (member.isPresent())
            return member.get();
        else
            return new Member();

    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
