package com.naryu.practice_project.controller;

import com.naryu.practice_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class MemberController {
    private final MemberService memberServic;

    public MemberController(MemberService memberServic) {
        this.memberServic = memberServic;
    }

    @GetMapping(value="/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
}
