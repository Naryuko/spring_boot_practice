package com.naryu.practice_project.repository;

import com.naryu.practice_project.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

// class level에서 실행하면 모든 테스트케이스를 한 번에 실행할 수 있다.
// 한 번에 실행 시 순서는 랜덤으로 되기 때문에 테스트가 순서에 의존하게 하면 안된다.
// 예를 들어 아래 코드에서는 한 테스트가 끝날 때 마다 repository에 멤버들이 저장되 다음 테스트에 영향을 준다.
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // @AfterEach 노테이션을 붙이면 매 테스트가 끝날 때마다 아래 함수가 실행된다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("Spring1");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring1");
        repository.save(member2);

        List<Member> list = repository.findAll();

        Assertions.assertThat(list.size()).isEqualTo(2);
    }

}
