package com.naryu.practice_project;

import com.naryu.practice_project.domain.Member;
import com.naryu.practice_project.repository.MemberRepository;
import com.naryu.practice_project.repository.MemoryMemberRepository;
import com.naryu.practice_project.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
