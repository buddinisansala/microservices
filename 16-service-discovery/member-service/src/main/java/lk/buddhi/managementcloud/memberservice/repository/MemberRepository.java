package lk.buddhi.managementcloud.memberservice.repository;

import lk.buddhi.managementcloud.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
