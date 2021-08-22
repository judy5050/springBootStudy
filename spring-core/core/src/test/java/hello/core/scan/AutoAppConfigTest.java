package hello.core.scan;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){

        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //설정 파일이 두개일경우 어떤식으로 빈이 등록되는지 궁금해 살펴봄
//        AnnotationConfigApplicationContext ab=new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println(ab.getBean(AppConfig.class));
//        System.out.println(ac.getBean(AutoAppConfig.class));
//        System.out.println(ac.getBean("memberServiceImpl", MemberService.class));
//        System.out.println(ab.getBean("memberService", MemberService.class));
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("beanDefinitionName = " + beanDefinitionName);
//        }
        MemberService memberService=ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
