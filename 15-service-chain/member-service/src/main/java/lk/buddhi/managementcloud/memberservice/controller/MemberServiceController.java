package lk.buddhi.managementcloud.memberservice.controller;

import lk.buddhi.managementcloud.memberservice.service.MemberService;
import lk.buddhi.managementcloud.model.member.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/services/members")
public class MemberServiceController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public Member save(@RequestBody Member member) {
        return memberService.save(member);
    }

    @GetMapping(value = "/{id}")
    public Member getMember(@PathVariable int id) {

        System.out.println("request came on "+LocalDateTime.now() + "  ++++++++++++++++++++++");
        return memberService.findById(id);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

}
