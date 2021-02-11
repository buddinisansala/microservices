package lk.buddhi.managementcloud.memberservice.service;

import lk.buddhi.managementcloud.model.member.Member;
import java.util.List;

public interface MemberService {

    Member save(Member member);

    Member findById(int id);

    List<Member> findAll();
}
