package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository1 = " + memberRepository1.getClass());
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void test(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService1 = ac.getBean("memberService", MemberServiceImpl.class);
        MemberServiceImpl memberService2 = ac.getBean("memberService", MemberServiceImpl.class);


        MemberRepository memberRepository1 = memberService1.getMemberRepository();
        MemberRepository memberRepository2 = memberService2.getMemberRepository();

        System.out.println("memberService1  = " + memberService1);
        System.out.println("memberService2  = " + memberService2);
        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("memberService -> memberRepository2 = " + memberRepository2);
//        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);

    }

    @Test
    void configurationDeep(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean=ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }

}
