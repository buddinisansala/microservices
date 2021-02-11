package com.buddhi.managementcloud.profileservice.controller;

import com.buddhi.managementcloud.commons.model.Book;
import com.buddhi.managementcloud.commons.model.Member;

import com.buddhi.managementcloud.profileservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ProfileController{

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/members", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Member save(@RequestBody Member member){
        return memberService.save(member);
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.GET)
    public Member fetch(@PathVariable(value = "id") int membersId) {
        return memberService.fetchById(membersId);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Member> fetch() {
        return memberService.fetchAllProfiles();
    }

}
