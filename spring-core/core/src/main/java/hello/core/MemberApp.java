package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    /**
     * AppConfig 사용방식
     */
//    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        //의존성 관계 주입 전 코드
////        MemberService memberService=new MemberServiceImpl();
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//
//        Member findMember = memberService.findMember(1L);
//        System.out.println("findMember = " + findMember.getName());
//        System.out.println("member = " + member.getName());
//    }

    /**
     * 스프링 사용 버전
     */
    public static void main(String[] args) {


        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
