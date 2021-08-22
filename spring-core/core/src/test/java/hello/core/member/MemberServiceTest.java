package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    //추상화에도 의존하고 구체화에도 의존
    //즉 ,DIP를 어긴다.
//    MemberService memberService=new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService= appConfig.memberService();
    }

    @Test
    void join(){

        //given
        Member member=new Member(1L,"memberA",Grade.VIP);


        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
        //then
        assertThat(member).isEqualTo(findMember);





    }


}
